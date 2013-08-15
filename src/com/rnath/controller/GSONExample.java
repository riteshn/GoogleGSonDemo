/**
 * 
 */
package com.fsb.controller;

import com.rnath.domain.Departments;
import com.google.gson.Gson;

/**
 * @author rnath
 *
 */
public class GSONExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String json = 
            "{"
                + "'title': 'Computing and Information systems',"
                + "'id' : 1,"
                + "'children' : 'true',"
                + "'groups' : [{"
                    + "'title' : 'Pro Git',"
                    + "'id' : 2,"
                    + "'children' : 'true',"
                    + "'groups' : [{"
                        + "'title' : 'Intro To Computing and Internet',"
                        + "'id' : 3,"
                        + "'children': 'false',"
                        + "'groups':[]"
                    + "}]" 
                + "}]"
            + "}";

        // Parse the json string to Java.
        Departments data = new Gson().fromJson(json, Departments.class);

        // Show it.
        System.out.println(data);

	}

}
