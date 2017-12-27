package Intermidiate;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TryWithResource {
	private static void printFile() throws IOException {

	    try(FileInputStream input = new FileInputStream("file.txt")) {

	        int data = input.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = input.read();
	        }
	    }
	}
	
	private static void printFile2() throws IOException {

	    try(  FileInputStream input = new FileInputStream("file.txt");
	          BufferedInputStream bufferedInput = new BufferedInputStream(input)
	    ) {

	        int data = bufferedInput.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = bufferedInput.read();
	        }
	    }
	}
	
	public static void main(String[] args) {
		try {
			printFile2();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(MyAutoClosable mac = new MyAutoClosable()) {
			mac.doIt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

class MyAutoClosable implements AutoCloseable {

    public void doIt() {
        System.out.println("MyAutoClosable doing it!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoClosable closed!");
    }
}