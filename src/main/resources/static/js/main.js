$(document).ready(function() {

	var showKanjiDetails = true;

	$('#nextKanji').click(nextKanji);

	$('#categoryN5').click(categoryFilter);
	$('#categoryN4').click(categoryFilter);
	$('#categoryN3').click(categoryFilter);
	$('#categoryN2').click(categoryFilter);
	$('#categoryN1').click(categoryFilter);

	function categoryFilter(e) {
		if ($(this).children("a").hasClass("active")) {
			$(this).children("a").removeClass("active");
		} else {
			$(this).children("a").addClass("active");
		}
		showKanjiDetails = false;
		nextKanji(e);
	}

	function nextKanji(e) {
		var url = "/random?categories=";
		$("li").each(function(index) {
			if ($(this).children("a").hasClass("active")) {
				url = url + $(this).text().trim() + ","
			}
		});
		if (!showKanjiDetails) {
			$("#nextKanji").text("Show meaning");
			$("#kanjiBlock").load(url, function() {
				$("#nextKanji").off('click');
				$("#nextKanji").on('click', nextKanji);
			});
			showKanjiDetails = true;
		} else {
			$("#nextKanji").text("Next kanji");
			showKanjiDetails = false;
			$("#kanjiOnyomi").show();
			$('#kanjiOnyomi').removeClass('invisible');
			$('#kanjiKunyomi').removeClass('invisible');
			$('#kanjiMeaning').removeClass('invisible');
		}
		e.preventDefault();
	}

	$(document).keypress(function(e) {
		if (e.keyCode === 0 || e.keyCode === 32) {
			nextKanji(e);
			e.preventDefault();
		}
	});
});
