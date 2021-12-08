$(document).ready(function($) {
	$.get('Json/province.json', function(data) {
		for (var i in data) {
			$("#proSelector").append("<option value='"+data[i].vu+"'>"+data[i].name+"</option>");
		};
	});

	$('#proSelector').change(function(event) {
		$('#citySelector').html('<option value="请选择城市">请选择城市</option>');
		var selectedPro = $("#proSelector option:selected").text();
		getProID(selectedPro, function(proID) {
			$.get('Json/city.json', function(data) {
				for (var i in data) {
					if(data[i].ProID == proID) {
						var cityName = data[i].name;
						var cityID = data[i].CityID;
						var ctiyvalue = data[i].value;
						$('#citySelector').append("<option value='"+ctiyvalue+"'>"+cityName+"</option>");
					}
				};
			});
		})
	});

	function getProID(proName, cb) {
		var proID = null;
		$.get('Json/province.json', function(data) {
			for (var i in data) {
				if(proName == data[i].name){
					proID = data[i].ProID;
					cb(proID);
				};
			};
		});
	}
});
