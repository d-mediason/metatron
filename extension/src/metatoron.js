chrome.tabs.getSelected(null, function(tab) {
	$('#pageUrl').text(tab.url);
	$('#pageTitle').text(tab.title);
});
$(function(){
	$('button#submit').on('click', function() {
		var pageTitle = $('#pageTitle').text();
		var pageUrl = $('#pageUrl').text();
		var srcUrl = $('#srcUrl').val();
		alert( [pageTitle,pageUrl,srcUrl].join(',') );
	});
});
