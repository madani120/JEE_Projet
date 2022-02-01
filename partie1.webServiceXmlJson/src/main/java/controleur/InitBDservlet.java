package controleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.helpers.FileUtils;


import outils.XmlFileToBD;

/**
 * Servlet implementation class InitBDservlet
 */
public class InitBDservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final XmlFileToBD loader = new XmlFileToBD();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitBDservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(){
    	
    	System.out.println("Chargement du fichier");
    	ServletContext s = getServletContext();
    	
    	downloadFileFromURL("https://donnees.roulez-eco.fr/opendata/instantane", s.getRealPath("/WEB-INF/doc/PrixCarburants_instantane.zip"));
    	unzip(s.getRealPath("/WEB-INF/doc/PrixCarburants.zip"),s.getRealPath("/WEB-INF/doc/PrixCarburants_instantane.xml"));
    	System.out.println("Fichier ajouter");
		
		try
		{
			loader.chargerFichier(s.getRealPath("/WEB-INF/doc/PrixCarburants_instantane.xml"));
			System.out.println(loader);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    	
    }
    
    
    /*Automatisation du telechargement du fichier zip */
    
    public static void downloadFileFromURL(String urlString, String destination) {
       
    	
		try {
			InputStream in = new URL(urlString).openStream();
			File out = new File(destination);
			Files.copy(in,out.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    
    /*deziper notre fichier telecharger */
    private static void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
