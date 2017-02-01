import static def.jquery.Globals.$;
import static jsweet.lang.Globals.eval;

import def.jquery.JQuery;
import jsweet.lang.Array;

public class Castafiore {

	public static void doRender(Object[] data) {

		for (Object o : data) {
			jsweet.lang.Object jo = new jsweet.lang.Object(o);
			String creation = (String) jo.$get("creation");
			String id = (String) jo.$get("id");
			eval(creation);
			JQuery el = $("#" + id);
			if (jo.$get("attributes") != null)
				el.attr(jo.$get("attributes"));
			if (jo.$get("styles") != null)
				el.css(jo.$get("styles"));

			if (jo.$get("events") != null) {
				Array<jsweet.lang.Object> events = (Array<jsweet.lang.Object>) jo.$get("events");
				for (jsweet.lang.Object ev : events) {
					el.on(ev.$get("eventName").toString(), (x, y) -> {
						eval((String) ev.$get("body"));
						return null;
					});
				}
			}
		}

		$(" *[data-mask]").each((i, e) -> {
			eval("$(this).mask($(this).attr('data-mask'))");
			return null;
		});

	}

	public static void server(jsweet.lang.Object params) {

		$(":checkbox").each((i, e) -> {
			if ($("this").is(":checked")) {
				params.$set("casta_value_" + $("this").attr("id"), "checked");
			} else {
				params.$set("casta_value_" + $("this").attr("id"), "");
			}
			return null;
		});
		$(" *[stf]").each((i, e) -> {
			// if(params["casta_value_"+$(this).attr("id")] == undefined)
			params.$set("casta_value_" + $("this").attr("id"), $("this").attr("value"));
			return null;
		});
		// params.requestId=requestId++;

		$.post("http://localhost:8081/castafiore/ui/tt", params, (data, b, c) -> {
			// $("#script_"+params['casta_applicationid']).append(data);
			doRender((Object[]) data);
			return null;
		}, "json");
	}

	public static void init(String applicationId) {
		$("<div></div>").attr("id", "root_" + applicationId).appendTo("body");
	}

	public static void load(String applicationId) {
		init(applicationId);
		$.getJSON("http://localhost:8081/castafiore/ui/sds?casta_applicationid=" + applicationId, (t, u, v) -> {
			doRender((Object[]) t);
			return null;
		});
	}

	public static void main(String[] args) {
		Castafiore.load("documentation");

	}

}
