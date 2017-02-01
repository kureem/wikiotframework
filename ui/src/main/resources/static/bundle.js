"Generated from Java with JSweet 1.1.1 - http://www.jsweet.org";
var Castafiore = (function () {
    function Castafiore() {
    }
    Castafiore.doRender = function (data) {
        for (var index121 = 0; index121 < data.length; index121++) {
            var o = data[index121];
            {
                var jo = new Object(o);
                var creation = jo["creation"];
                var id = jo["id"];
                eval(creation);
                var el = $("#" + id);
                if (jo["attributes"] != null)
                    el.attr(jo["attributes"]);
                if (jo["styles"] != null)
                    el.css(jo["styles"]);
                if (jo["events"] != null) {
                    var events = jo["events"];
                    for (var index122 = 0; index122 < events.length; index122++) {
                        var ev = events[index122];
                        {
                            el.on(ev["eventName"].toString(), (function (ev) {
                                return function (x, y) {
                                    eval(ev["body"]);
                                    return null;
                                };
                            })(ev));
                        }
                    }
                }
            }
        }
        $(" *[data-mask]").each(function (i, e) {
            eval("$(this).mask($(this).attr(\'data-mask\'))");
            return null;
        });
    };
    Castafiore.server = function (params) {
        $(":checkbox").each(function (i, e) {
            if ($("this").is(":checked")) {
                params["casta_value_" + $("this").attr("id")] = "checked";
            }
            else {
                params["casta_value_" + $("this").attr("id")] = "";
            }
            return null;
        });
        $(" *[stf]").each(function (i, e) {
            params["casta_value_" + $("this").attr("id")] = $("this").attr("value");
            return null;
        });
        $.post("http://localhost:8081/castafiore/ui/tt", params, function (data, b, c) {
            Castafiore.doRender(data);
            return null;
        }, "json");
    };
    Castafiore.init = function (applicationId) {
        $("<div></div>").attr("id", "root_" + applicationId).appendTo("body");
    };
    Castafiore.load = function (applicationId) {
        Castafiore.init(applicationId);
        $.getJSON("http://localhost:8081/castafiore/ui/sds?casta_applicationid=" + applicationId, function (t, u, v) {
            Castafiore.doRender(t);
            return null;
        });
    };
    Castafiore.main = function (args) {
        Castafiore.load("documentation");
    };
    return Castafiore;
}());
Castafiore.main(null);
