/**
 * 
 */
	$(exampleModal).on("show.bs.modal", function(event){
		let who = event.relatedTarget.dataset['who'];
		let $modalBody = $(this).find(".modal-body");
		let viewURL = this.dataset['url'];
		if(who){
			let settings = {
				url : viewURL,
				dataType : "html", // Accept:application/json,
				data : {
					who : who
				},
				success : function(resp) {
					$modalBody.html(resp);
				}
			} //request line,header,body -> response processing

			$.ajax(settings);
		}
	}).on("hidden.bs.modal", function(event){
		let $modalBody = $(this).find(".modal-body");
		$modalBody.empty();
	});