package com.io.zip;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ZipImageLoader {
	protected ZipImageLoader() {
	}

	public static Map<String, BufferedImage> loadJpgImagesFromZip(InputStream zipStream) throws IOException {
		Map<String, BufferedImage> images = new HashMap<>();
		try (ZipInputStream stream = new ZipInputStream(zipStream)) {
			ZipEntry entry;
			while ((entry = stream.getNextEntry()) != null) {
				String name = entry.getName().toLowerCase();
				if (!entry.isDirectory() && name.endsWith(".jpg")) {
					BufferedImage image = ImageIO.read(stream);
					if (image != null) {
						String cardId = new File(name).getName().replace(".jpg", "");
						images.put(cardId, image);
					}
				}
				stream.closeEntry();
			}
		}
		return images;
	}
}

class ImageComponentLoader {
	protected ImageComponentLoader() {
	}

	public static Map<String, JComponent> preloadImageComponents(Map<String, BufferedImage> imageMap) {
		Map<String, JComponent> componentMap = new HashMap<>();
		for (Map.Entry<String, BufferedImage> entry : imageMap.entrySet()) {
			JLabel label = new JLabel(new ImageIcon(entry.getValue()));
			componentMap.put(entry.getKey(), label);
		}
		return componentMap;
	}
}
