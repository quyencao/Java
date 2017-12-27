package Intermidiate;

public class CheckedUncheckedException {
	public void storeDataFromUrl(String url) {
        try {
            String data = readDataFromUrl(url);
        } catch (BadUrlException e) {
            e.printStackTrace();
        }
        
        String data = readDataFromUrl(url);
    }

    public String readDataFromUrl(String url) throws BadUrlException {
        if(isUrlBad(url)){
            throw new BadUrlException("Bad URL: " + url);
        }

        String data = null;
        //read lots of data over HTTP and return
        //it as a String instance.

        return data;
    }
    
    public boolean isUrlBad(String url) {
    	return true;
    }
}

class BadUrlException extends RuntimeException {
    public BadUrlException(String s) {
        super(s);
    }
}