using System;
using System.Collections.Generic;

public class ConfReader {

	public IDictionary<String, Object> Parse() {
		string file = System.IO.File.ReadAllText(@"ENTER FILE PATH HERE");

		// Implementation here
		IDictionary<String, Object> parsedMap = new Dictionary<String, Object>();  
		return parsedMap;
	}
}