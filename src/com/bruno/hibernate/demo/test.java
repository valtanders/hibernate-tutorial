package com.bruno.hibernate.demo;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		String lista = "bruno";
		
		for (String s : Arrays.asList(lista.split("\\s*,\\s*"))) {
			System.out.println(s);
		}

	}

}
