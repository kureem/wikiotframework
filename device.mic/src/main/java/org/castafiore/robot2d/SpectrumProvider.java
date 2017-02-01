package org.castafiore.robot2d;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import org.wikiot.client.device.Device;
import org.wikiot.client.device.FunctionHandler;

import echo.alich.spectrum.Spectrum;
import echo.alich.spectrum.SpectrumFactory;

public class SpectrumProvider extends Device implements FunctionHandler {

	private TargetDataLine line;

	public SpectrumProvider() {
	}

	public void start() {
		double max = 0;
		while (true) {
			Spectrum<?> sp2 = SpectrumFactory.getSpectrum(recordSample());
			System.out.println("Maximum: " + sp2.getMaxFrequency());
			int count = 0;
			for (double d : sp2.getSpectrum()) {

				if (d > max) {
					max = d;
				}
				if ((count % 100) == 0) {
					System.out.println(max / 100000);
					int level = Math.round(new Double(max / 1000000).floatValue());
					System.out.println(level);
					sendLevel(level);

				}
				count++;

			}
		}
	}

	private void sendLevel(int level) {
		Map<String, String> params = new LinkedHashMap<String, String>();
		params.put("l", level + "");
		propagateEvent("Pitch", params);
	}

	private boolean initMic() {
		AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 1, 2, 44100, false);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		if (!AudioSystem.isLineSupported(info)) {
			System.out.println("not supported");
			return false;
		}
		try {
			line = (TargetDataLine) AudioSystem.getLine(info);
			line.open(format);
		} catch (LineUnavailableException ex) {
			throw new RuntimeException(ex);
		}
		return true;

	}

	private short[] recordSample() {
		if (line == null) {
			if (!initMic()) {
				return null;
			}

		}
		byte[] data = new byte[line.getBufferSize() / 5];
		line.start();

		short[] shorts = new short[data.length / 2];
		line.read(data, 0, data.length);
		ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts);
		return shorts;

	}

	@Override
	public void execute(String name, Map<String, String> input) {
		if ("stop".equalsIgnoreCase(name)) {
			try {
				disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();

		connect();
	}

	@Override
	public void onConnected(Device device) {
		start();
	}

}
