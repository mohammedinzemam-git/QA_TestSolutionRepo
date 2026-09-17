package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.EmployeeData;

import java.io.File;
import java.io.IOException;

public class JsonReader {

	private static EmployeeData employeeData;

	static {

		ObjectMapper mapper = new ObjectMapper();

		try {

			File jsonFile = new File(
					System.getProperty("user.dir")
					+ "/src/test/java/resources/employee.json");

			employeeData =
					mapper.readValue(
							jsonFile,
							EmployeeData.class);

		} catch (IOException e) {

			e.printStackTrace();

			throw new RuntimeException(
					"Failed to load employee.json");
		}
	}

	public static EmployeeData getEmployeeData() {

		return employeeData;
	}

}
