import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadsManager implements Runnable{
	private String link;
	private File outputFile;
	
	//----Paths----
	private String fileSeparator = System.getProperty("file.separator");
	private String downlaodFolderPath = "C:" + fileSeparator + "Users" + fileSeparator + "bashi" + fileSeparator + "OneDrive" + fileSeparator + "Desktop" + fileSeparator + "DoenloadManagerProject";
	
	private File defaultDownloadFolder = new File(downlaodFolderPath);
	
	//----Constructor----
	public DownloadsManager(String link) {
		this.link = link;
		
		if(!defaultDownloadFolder.exists()) {
			defaultDownloadFolder.mkdirs();
		}
	}

	@Override
	public void run() {
		try {
			URL url = new URL(link);
			HttpURLConnection htpConnection = (HttpURLConnection)url.openConnection();
			
			//----InputStream arbeitet immmer mit Byte----
			BufferedInputStream bufferedInputStream = new BufferedInputStream(htpConnection.getInputStream());
			
			
			//---Datei schreiben / erstellen    
			outputFile = new File(defaultDownloadFolder,"newONe.mp3");//hier datai typ geben(mp3,txt,mp4,word....)
			
			OutputStream outputStream = new FileOutputStream(outputFile);//in welche datai soll es gespeichert werden
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream,1024);// 1024 byte = 1k byte = Grpßer des Bufferdspeichers
			
			byte[] buffer = new byte[1024];
			int downloaded = 0;//wieviel byte ist gesamt geladen worden?
			int readByte = 0;//wieviel byte sind aktuel geladen?
 			
			while((readByte = bufferedInputStream.read(buffer,0,1024)) >= 0) {
			bufferedOutputStream.write(buffer,0,1024);
			downloaded += readByte;
			
			System.out.println("bereits: " + downloaded + "Byte geladen");
			}
			bufferedOutputStream.close();
			bufferedInputStream.close();
			System.out.println("Download erfolgreich");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
