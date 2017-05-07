package com.filters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;

public class GZIPResponseStream extends ServletOutputStream {
	protected ByteArrayOutputStream baos = null;
	protected GZIPOutputStream gzipstream = null;
	protected boolean closed = false;
	protected HttpServletResponse response = null;
	protected ServletOutputStream output = null;

	public GZIPResponseStream(HttpServletResponse response) throws IOException { 
		super();
		closed = false;
		this.response = response;
		this.output = response.getOutputStream();
		baos = new ByteArrayOutputStream();
		gzipstream = new GZIPOutputStream(baos);
	}

	@Override
	public void close() throws IOException { 
		if (!closed) {
			gzipstream.finish();
			byte[] bytes = baos.toByteArray();
			
			response.addHeader("Content-Length", Integer.toString(bytes.length));
			response.addHeader("Content-Encoding", "gzip");
			output.write(bytes);
			output.flush();
			output.close();
			closed = true;
		}
	}
	
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setWriteListener(WriteListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(int b) throws IOException { 
		if (!closed) {
			gzipstream.write(b);
		}
	}
	
	@Override
	public void write(byte[] b) throws IOException { 
		write(b, 0, b.length);
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		if (!closed) {
			gzipstream.write(b, off, len);
		} 
	}
	
	public boolean closed() {
		return this.closed;
	}
	
	@Override
	public void flush() throws IOException { 
		gzipstream.flush();
	}
	
	public void reset() {
		
	}
}
