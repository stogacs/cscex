class ConfReader {
	
	function parse(file, callback) {
		//Implementation here
		var parsedMap = {};
  		if (!file) {
    		return;
  		}
  		var reader = new FileReader();
  		reader.addEventListener('load', function(e) {
    		var text = e.target.result;

    		callback(parsedMap);
		});
  		reader.readAsText(file);

  		
	}
}