package com.shawver.camping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leeshawver
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	private Long item_pk;
	private String item_id;
	private String item_name;
	private String item_manufacturer;
}