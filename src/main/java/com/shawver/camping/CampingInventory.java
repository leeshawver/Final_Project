package com.shawver.camping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shawver.ComponentScanMarker;

/**
 * @author leeshawver
 *
 */
@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class} )
public class CampingInventory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CampingInventory.class, args);
	}

}
