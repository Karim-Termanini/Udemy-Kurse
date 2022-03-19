
public class Main {

	public static void main(String[] args) {
		//DownloadsManager downloadsManager = new DownloadsManager("Test");
		//https://filesamples.com/samples/document/txt/sample3.txt
		
		String downloadLink = "https://download.samplelib.com/mp3/sample-15s.mp3";
		new Thread(new DownloadsManager(downloadLink)).start();
		
	}

}
