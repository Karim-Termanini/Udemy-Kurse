
public class Main {

	public static void main(String[] args) {
		//der Link in dem downloadLink geben
		String downloadLink = "https://download.samplelib.com/mp3/sample-15s.mp3";
		new Thread(new DownloadsManager(downloadLink)).start();
		
	}

}
