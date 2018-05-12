package com.test.predqm.dataprocessor;

import static com.test.predqm.constant.Constants.INPUT_FILE_NAME;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import com.test.predqm.utils.PropertyUtils;

public class DataProcessorService {

	public static void process() {
		String configFile = System.getProperty("config");
		if (configFile == null) {
			System.out.println("config path not set in system porperties");
			return;
		}
		System.out.println(" DataProcessorService started ");
		PropertyUtils properties = new PropertyUtils(configFile);
		//String inputFileName = properties.getProperty(INPUT_FILE_NAME);

		WatchService watchService;
		try {
			watchService = FileSystems.getDefault().newWatchService();
			Path path = Paths.get(properties.getProperty(INPUT_FILE_NAME));
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);
			WatchKey key;
			while ((key = watchService.take()) != null) {
				for (WatchEvent<?> event : key.pollEvents()) {
					//System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
					
				}
				key.reset();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		process();

		System.out.println(System.getProperty("config"));
	}
}
