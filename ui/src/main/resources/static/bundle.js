var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var app;
(function (app) {
    var Boot = (function () {
        function Boot() {
        }
        Boot.main = function (args) {
            var root = new builder.WireFrame("root");
            $(document).ready((function (root) {
                return function () {
                    root.render();
                    return null;
                };
            })(root));
        };
        return Boot;
    }());
    app.Boot = Boot;
    Boot["__class"] = "app.Boot";
})(app || (app = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var app;
(function (app) {
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
        return Castafiore;
    }());
    app.Castafiore = Castafiore;
    Castafiore["__class"] = "app.Castafiore";
})(app || (app = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var io;
    (function (io) {
        var Remote = (function () {
            function Remote() {
            }
            Remote.get = function (url, params, dataType, handler) {
                var onSuccess = function (t, u, v) {
                    var s = new XMLSerializer().serializeToString(t);
                    handler.handleResponse(s);
                    return null;
                };
                $.get(url).then(onSuccess);
            };
            Remote.getXHTML = function (url, params, handler) {
                Remote.get(url, params, "application/xhtml+xml", handler);
            };
            Remote.getJSON = function (url, params, handler) {
                Remote.get(url, params, "application/json", handler);
            };
            return Remote;
        }());
        io.Remote = Remote;
        Remote["__class"] = "framework.io.Remote";
    })(io = framework.io || (framework.io = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var JSColor = (function () {
        function JSColor(red, green, blue, alpha) {
            this.red = 0;
            this.green = 0;
            this.blue = 0;
            this.alpha = 0;
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.alpha = alpha;
        }
        JSColor.prototype.getRed = function () {
            return this.red;
        };
        JSColor.prototype.setRed = function (red) {
            this.red = red;
        };
        JSColor.prototype.getGreen = function () {
            return this.green;
        };
        JSColor.prototype.setGreen = function (green) {
            this.green = green;
        };
        JSColor.prototype.getBlue = function () {
            return this.blue;
        };
        JSColor.prototype.setBlue = function (blue) {
            this.blue = blue;
        };
        JSColor.prototype.getAlpha = function () {
            return this.alpha;
        };
        JSColor.prototype.setAlpha = function (alpha) {
            this.alpha = alpha;
        };
        return JSColor;
    }());
    framework.JSColor = JSColor;
    JSColor["__class"] = "framework.JSColor";
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var JSMap = (function () {
        function JSMap() {
        }
        JSMap.prototype.getJavascript = function () {
            return JSON.stringify(this);
        };
        return JSMap;
    }());
    framework.JSMap = JSMap;
    JSMap["__class"] = "framework.JSMap";
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var renderer;
    (function (renderer) {
        var ContainerRenderer = (function () {
            function ContainerRenderer() {
            }
            ContainerRenderer.prototype.doRender = function (c) {
                var jq = $("#" + c.getId());
                var tag = c.getTag();
                var rendered = c.isRendered();
                var name = c.getName();
                var html = c.getHtml();
                var parent = c.getParent();
                if (!rendered) {
                    jq.remove();
                    var shtml = "<" + tag + "></" + tag + ">";
                    var njq = $(shtml);
                    njq.attr("name", name).attr("id", c.getId()).html(html);
                    this.renderAttributes(njq, c);
                    this.renderStyles(njq, c);
                    if (parent == null) {
                        njq.appendTo($("body"));
                    }
                    else {
                        if (c.getParent() != null && c.getParent() instanceof framework.JSXHTMLFragment) {
                            var q = $("#" + parent.getId()).find("[name=" + c.getName() + "]");
                            if (q.length > 0)
                                $("#" + parent.getId()).find("[name=" + c.getName() + "]").replaceWith(njq);
                            else
                                njq.appendTo($("#" + parent.getId()));
                        }
                        else {
                            njq.appendTo($("#" + parent.getId()));
                        }
                    }
                }
                else {
                    this.clearAttributes(jq);
                    this.clearStyles(jq);
                    this.renderAttributes(jq, c);
                    this.renderStyles(jq, c);
                }
            };
            ContainerRenderer.prototype.renderAttributes = function (njq, c) {
                for (var index123 = c.getAttributeNames().iterator(); index123.hasNext();) {
                    var key = index123.next();
                    {
                        njq.attr(key, c.getAttribute(key));
                    }
                }
            };
            ContainerRenderer.prototype.clearAttributes = function (jq) {
                var elem = jq[0];
                var attrs = elem.attributes;
                for (var i = 0; i < attrs.length; i++) {
                    jq.removeAttr(attrs[i].name);
                }
            };
            ContainerRenderer.prototype.clearStyles = function (jq) {
                jq.removeAttr("style");
            };
            ContainerRenderer.prototype.renderStyles = function (njq, c) {
                for (var index124 = c.getStyleNames().iterator(); index124.hasNext();) {
                    var key = index124.next();
                    {
                        njq.css(key, c.getStyle(key));
                    }
                }
            };
            return ContainerRenderer;
        }());
        renderer.ContainerRenderer = ContainerRenderer;
        ContainerRenderer["__class"] = "framework.renderer.ContainerRenderer";
        ContainerRenderer["__interfaces"] = ["framework.renderer.Renderer"];
    })(renderer = framework.renderer || (framework.renderer = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var JSContainer = (function () {
        function JSContainer(name, tag) {
            var _this = this;
            this.listeners = (new java.util.HashMap());
            this.attributes = (new java.util.HashMap());
            this.styles = (new java.util.HashMap());
            this.children = (new java.util.LinkedList());
            this.html = "";
            this.tag = "";
            this.name = "";
            this.rendered = false;
            this.renderers = (new java.util.ArrayList());
            if (((typeof name === 'string') || name === null) && ((typeof tag === 'string') || tag === null)) {
                var __args = Array.prototype.slice.call(arguments);
                this.listeners = new java.util.HashMap();
                this.attributes = new java.util.HashMap();
                this.styles = new java.util.HashMap();
                this.children = new java.util.LinkedList();
                this.html = "";
                this.tag = "";
                this.name = "";
                this.rendered = false;
                this.renderers = new java.util.ArrayList();
                (function () {
                    _this.tag = tag;
                    _this.name = name;
                    _this.addClass(/* getSimpleName */ (function (c) { return c["__class"] ? c["__class"].substring(c["__class"].lastIndexOf('.') + 1) : c.name.substring(c.name.lastIndexOf('.') + 1); })(_this.constructor));
                })();
            }
            else if (((typeof name === 'string') || name === null) && tag === undefined) {
                var __args = Array.prototype.slice.call(arguments);
                var tag_1 = __args[0];
                this.listeners = new java.util.HashMap();
                this.attributes = new java.util.HashMap();
                this.styles = new java.util.HashMap();
                this.children = new java.util.LinkedList();
                this.html = "";
                this.tag = "";
                this.name = "";
                this.rendered = false;
                this.renderers = new java.util.ArrayList();
                (function () {
                    _this.tag = tag_1;
                    _this.addClass(/* getSimpleName */ (function (c) { return c["__class"] ? c["__class"].substring(c["__class"].lastIndexOf('.') + 1) : c.name.substring(c.name.lastIndexOf('.') + 1); })(_this.constructor));
                })();
            }
            else
                throw new Error('invalid overload');
        }
        JSContainer.DEFAULT_RENDERER_$LI$ = function () { if (JSContainer.DEFAULT_RENDERER == null)
            JSContainer.DEFAULT_RENDERER = new framework.renderer.ContainerRenderer(); return JSContainer.DEFAULT_RENDERER; };
        ;
        JSContainer.prototype.getRenderers = function () {
            return this.renderers;
        };
        JSContainer.prototype.addRenderer = function (renderer) {
            if (!this.renderers.contains(renderer)) {
                this.renderers.add(renderer);
            }
        };
        JSContainer.prototype.getId = function () {
            if (this.id == null) {
                this.id = this.uid();
            }
            return this.id;
        };
        JSContainer.prototype.uid = function () {
            var s = java.lang.System.currentTimeMillis() + "_" + Math.random();
            s = s.split('.').join('_');
            return s;
        };
        JSContainer.prototype.addClass = function (styleClass) {
            var styles = this.getAttribute("class");
            if (styles == null) {
                styles = "";
            }
            var aStyles = styles.split(" ");
            var add = true;
            for (var index125 = 0; index125 < aStyles.length; index125++) {
                var style = aStyles[index125];
                {
                    if ((style.trim() === styleClass)) {
                        add = false;
                    }
                }
            }
            if (add)
                this.setAttribute("class", styles.trim() + " " + styleClass);
            return this;
        };
        JSContainer.prototype.addChild = function (container) {
            container.parent = this;
            this.children.add(container);
        };
        JSContainer.prototype.addEventListener = function (listener, type) {
            if (!this.listeners.containsKey(type)) {
                this.listeners.put(type, (new java.util.ArrayList()));
            }
            if (!this.listeners.get(type).contains(listener)) {
                this.listeners.get(type).add(listener);
            }
        };
        JSContainer.prototype.getTag = function () {
            return this.tag;
        };
        JSContainer.prototype.setTag = function (tag) {
            this.tag = tag;
        };
        JSContainer.prototype.setStyle = function (key, value) {
            this.styles.put(key, value);
        };
        JSContainer.prototype.getStyle = function (key) {
            return this.styles.get(key);
        };
        JSContainer.prototype.setAttribute = function (key, value) {
            this.attributes.put(key, value);
        };
        JSContainer.prototype.getAttribute = function (key) {
            return this.attributes.get(key);
        };
        JSContainer.prototype.getName = function () {
            return this.name;
        };
        JSContainer.prototype.setName = function (name) {
            this.name = name;
        };
        JSContainer.prototype.getParent = function () {
            return this.parent;
        };
        JSContainer.prototype.getChildren = function () {
            return this.children;
        };
        JSContainer.prototype.getStyleNames = function () {
            return this.styles.keySet();
        };
        JSContainer.prototype.getAttributeNames = function () {
            return this.attributes.keySet();
        };
        JSContainer.prototype.getHtml = function () {
            return this.html;
        };
        JSContainer.prototype.isRendered = function () {
            return this.rendered;
        };
        JSContainer.prototype.render = function () {
            if (this.renderers.isEmpty()) {
                this.renderers.add(JSContainer.DEFAULT_RENDERER_$LI$());
            }
            for (var index126 = this.renderers.iterator(); index126.hasNext();) {
                var renderer_1 = index126.next();
                renderer_1.doRender(this);
            }
            for (var index127 = this.getChildren().iterator(); index127.hasNext();) {
                var child = index127.next();
                {
                    child.render();
                }
            }
            this.rendered = true;
        };
        return JSContainer;
    }());
    framework.JSContainer = JSContainer;
    JSContainer["__class"] = "framework.JSContainer";
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var app;
(function (app) {
    var Chimebler = (function (_super) {
        __extends(Chimebler, _super);
        function Chimebler() {
            _super.call(this, "chimebler", "div");
            this.loginPage = new app.CHLogin();
            this.addChild(this.loginPage);
        }
        return Chimebler;
    }(framework.JSContainer));
    app.Chimebler = Chimebler;
    Chimebler["__class"] = "app.Chimebler";
})(app || (app = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var builder;
(function (builder) {
    var DimensionEditor = (function (_super) {
        __extends(DimensionEditor, _super);
        function DimensionEditor(name) {
            _super.call(this, name, "div");
            this.addClass("DimensionEditor");
        }
        return DimensionEditor;
    }(framework.JSContainer));
    builder.DimensionEditor = DimensionEditor;
    DimensionEditor["__class"] = "builder.DimensionEditor";
})(builder || (builder = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var builder;
(function (builder) {
    var WireFrame = (function (_super) {
        __extends(WireFrame, _super);
        function WireFrame(name) {
            _super.call(this, name, "div");
            var panel = new framework.JSPanel("s");
            panel.addChild(new framework.JSContainer("p"));
            this.addChild(panel);
        }
        return WireFrame;
    }(framework.JSContainer));
    builder.WireFrame = WireFrame;
    WireFrame["__class"] = "builder.WireFrame";
})(builder || (builder = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var JSInput = (function (_super) {
        __extends(JSInput, _super);
        function JSInput(name) {
            _super.call(this, name, "input");
            this.setType("text");
        }
        JSInput.prototype.setType = function (type) {
            this.setAttribute("type", type);
        };
        return JSInput;
    }(framework.JSContainer));
    framework.JSInput = JSInput;
    JSInput["__class"] = "framework.JSInput";
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var JSTextArea = (function (_super) {
        __extends(JSTextArea, _super);
        function JSTextArea(name) {
            _super.call(this, name, "textarea");
        }
        return JSTextArea;
    }(framework.JSContainer));
    framework.JSTextArea = JSTextArea;
    JSTextArea["__class"] = "framework.JSTextArea";
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var JSXHTMLFragment = (function (_super) {
        __extends(JSXHTMLFragment, _super);
        function JSXHTMLFragment(name, templateId) {
            _super.call(this, name, "div");
            this.templateId = templateId;
        }
        JSXHTMLFragment.prototype.getTemplateId = function () {
            return this.templateId;
        };
        JSXHTMLFragment.prototype.setTemplateId = function (templateId) {
            this.templateId = templateId;
        };
        JSXHTMLFragment.prototype.getHtml = function () {
            return $("#" + this.templateId).html();
        };
        return JSXHTMLFragment;
    }(framework.JSContainer));
    framework.JSXHTMLFragment = JSXHTMLFragment;
    JSXHTMLFragment["__class"] = "framework.JSXHTMLFragment";
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSCarousel = (function (_super) {
            __extends(ONSCarousel, _super);
            function ONSCarousel(name) {
                _super.call(this, name, "ons-carousel");
                this.fullscreen = false;
                this.overscrollable = false;
                this.centered = false;
                this.autoScroll = false;
                this.autoScrollRatio = 0;
                this.swipeable = false;
                this.disabled = false;
                this.autoRefresh = false;
            }
            ONSCarousel.prototype.setActiveIndex = function (index, options) {
            };
            ONSCarousel.prototype.next = function (options) {
            };
            ONSCarousel.prototype.prev = function (options) {
            };
            ONSCarousel.prototype.refresh = function () {
            };
            ONSCarousel.prototype.first = function () {
            };
            ONSCarousel.prototype.last = function () {
            };
            ONSCarousel.prototype.setBoolean = function (attr, b) {
                if (b) {
                    this.setAttribute(attr, "true");
                }
                else {
                    this.setAttribute(attr, null);
                }
            };
            ONSCarousel.prototype.getDirection = function () {
                return this.direction;
            };
            ONSCarousel.prototype.setDirection = function (direction) {
                this.direction = direction;
                this.setAttribute("direction", direction);
            };
            ONSCarousel.prototype.isFullscreen = function () {
                return this.fullscreen;
            };
            ONSCarousel.prototype.setFullscreen = function (fullscreen) {
                this.fullscreen = fullscreen;
                this.setBoolean("fullscreen", fullscreen);
            };
            ONSCarousel.prototype.isOverscrollable = function () {
                return this.overscrollable;
            };
            ONSCarousel.prototype.setOverscrollable = function (overscrollable) {
                this.overscrollable = overscrollable;
                this.setBoolean("overscrollable", overscrollable);
            };
            ONSCarousel.prototype.isCentered = function () {
                return this.centered;
            };
            ONSCarousel.prototype.setCentered = function (centered) {
                this.centered = centered;
                this.setBoolean("centered", centered);
            };
            ONSCarousel.prototype.getItemWidth = function () {
                return this.itemWidth;
            };
            ONSCarousel.prototype.setItemWidth = function (itemWidth) {
                this.itemWidth = itemWidth;
                this.setAttribute("item-width", itemWidth);
            };
            ONSCarousel.prototype.getItemHeight = function () {
                return this.itemHeight;
            };
            ONSCarousel.prototype.setItemHeight = function (itemHeight) {
                this.itemHeight = itemHeight;
                this.setAttribute("item-height", itemHeight);
            };
            ONSCarousel.prototype.isAutoScroll = function () {
                return this.autoScroll;
            };
            ONSCarousel.prototype.setAutoScroll = function (autoScroll) {
                this.autoScroll = autoScroll;
                this.setBoolean("auto-scroll", autoScroll);
            };
            ONSCarousel.prototype.getAutoScrollRatio = function () {
                return this.autoScrollRatio;
            };
            ONSCarousel.prototype.setAutoScrollRatio = function (autoScrollRatio) {
                this.autoScrollRatio = autoScrollRatio;
                this.setAttribute("auto-scroll-ratio", autoScrollRatio + "");
            };
            ONSCarousel.prototype.isSwipeable = function () {
                return this.swipeable;
            };
            ONSCarousel.prototype.setSwipeable = function (swipeable) {
                this.swipeable = swipeable;
                this.setBoolean("swipable", swipeable);
            };
            ONSCarousel.prototype.isDisabled = function () {
                return this.disabled;
            };
            ONSCarousel.prototype.setDisabled = function (disabled) {
                this.disabled = disabled;
                this.setBoolean("disabled", disabled);
            };
            ONSCarousel.prototype.getInitialIndex = function () {
                return this.initialIndex;
            };
            ONSCarousel.prototype.setInitialIndex = function (initialIndex) {
                this.initialIndex = initialIndex;
                this.setAttribute("initial-index", initialIndex.toString());
            };
            ONSCarousel.prototype.isAutoRefresh = function () {
                return this.autoRefresh;
            };
            ONSCarousel.prototype.setAutoRefresh = function (autoRefresh) {
                this.autoRefresh = autoRefresh;
                this.setBoolean("auto-refresh", autoRefresh);
            };
            ONSCarousel.prototype.getAnimation = function () {
                return this.animation;
            };
            ONSCarousel.prototype.setAnimation = function (animation) {
                this.animation = animation;
                this.setAttribute("animation", animation);
            };
            ONSCarousel.prototype.getAnimationOptions = function () {
                return this.animationOptions;
            };
            ONSCarousel.prototype.setAnimationOptions = function (animationOptions) {
                this.animationOptions = animationOptions;
                if (animationOptions != null)
                    this.setAttribute("animation-options", JSON.stringify(animationOptions));
                else
                    this.setAttribute("animation-options", null);
            };
            ONSCarousel.prototype.getPostchange = function () {
                return this.postchange;
            };
            ONSCarousel.prototype.setPostchange = function (postchange) {
                this.postchange = postchange;
                this.addEventListener(postchange, "postchange");
            };
            ONSCarousel.prototype.getRefresh = function () {
                return this.__refresh;
            };
            ONSCarousel.prototype.setRefresh = function (refresh) {
                this.__refresh = refresh;
                this.addEventListener(refresh, "refresh");
            };
            ONSCarousel.prototype.getOverscroll = function () {
                return this.overscroll;
            };
            ONSCarousel.prototype.setOverscroll = function (overscroll) {
                this.overscroll = overscroll;
                this.addEventListener(overscroll, "overscroll");
            };
            return ONSCarousel;
        }(framework.JSContainer));
        mobile.ONSCarousel = ONSCarousel;
        ONSCarousel["__class"] = "framework.mobile.ONSCarousel";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSCarouselItem = (function (_super) {
            __extends(ONSCarouselItem, _super);
            function ONSCarouselItem(name) {
                _super.call(this, name, "ons-carousel-item");
            }
            return ONSCarouselItem;
        }(framework.JSContainer));
        mobile.ONSCarouselItem = ONSCarouselItem;
        ONSCarouselItem["__class"] = "framework.mobile.ONSCarouselItem";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSCol = (function (_super) {
            __extends(ONSCol, _super);
            function ONSCol(name) {
                _super.call(this, name, "ons-col");
            }
            ONSCol.prototype.getVerticalAlign = function () {
                return this.verticalAlign;
            };
            ONSCol.prototype.setVerticalAlign = function (verticalAlign) {
                this.verticalAlign = verticalAlign;
                this.setAttribute("vertical-align", verticalAlign);
            };
            ONSCol.prototype.getWidth = function () {
                return this.width;
            };
            ONSCol.prototype.setWidth = function (width) {
                this.width = width;
                this.setAttribute("width", width);
            };
            return ONSCol;
        }(framework.JSContainer));
        mobile.ONSCol = ONSCol;
        ONSCol["__class"] = "framework.mobile.ONSCol";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSIcon = (function (_super) {
            __extends(ONSIcon, _super);
            function ONSIcon(name) {
                _super.call(this, name, "ons-icon");
                this.fixedWidth = false;
                this.spin = false;
            }
            ONSIcon.prototype.getIcon = function () {
                return this.icon;
            };
            ONSIcon.prototype.setIcon = function (icon) {
                this.icon = icon;
                this.setAttribute("icon", icon);
            };
            ONSIcon.prototype.getSize = function () {
                return this.size;
            };
            ONSIcon.prototype.setSize = function (size) {
                this.size = size;
                this.setAttribute("size", size);
            };
            ONSIcon.prototype.getRotate = function () {
                return this.rotate;
            };
            ONSIcon.prototype.setRotate = function (rotate) {
                this.rotate = rotate;
                this.setAttribute("rotate", rotate);
            };
            ONSIcon.prototype.isFixedWidth = function () {
                return this.fixedWidth;
            };
            ONSIcon.prototype.setFixedWidth = function (fixedWidth) {
                this.fixedWidth = fixedWidth;
                this.setAttribute("fixed-width", fixedWidth + "");
            };
            ONSIcon.prototype.isSpin = function () {
                return this.spin;
            };
            ONSIcon.prototype.setSpin = function (spin) {
                this.spin = spin;
                if (spin) {
                    this.setAttribute("spin", "true");
                }
                else {
                    this.setAttribute("spin", null);
                }
            };
            return ONSIcon;
        }(framework.JSContainer));
        mobile.ONSIcon = ONSIcon;
        ONSIcon["__class"] = "framework.mobile.ONSIcon";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSIf = (function (_super) {
            __extends(ONSIf, _super);
            function ONSIf(name) {
                _super.call(this, name, "ons-if");
            }
            ONSIf.prototype.getPlatform = function () {
                return this.platform;
            };
            ONSIf.prototype.setPlatform = function (platform) {
                this.platform = platform;
                this.setAttribute("platform", platform);
            };
            ONSIf.prototype.getOrientation = function () {
                return this.orientation;
            };
            ONSIf.prototype.setOrientation = function (orientation) {
                this.orientation = orientation;
                this.setAttribute("orientation", orientation);
            };
            return ONSIf;
        }(framework.JSContainer));
        mobile.ONSIf = ONSIf;
        ONSIf["__class"] = "framework.mobile.ONSIf";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSModal = (function (_super) {
            __extends(ONSModal, _super);
            function ONSModal(name) {
                _super.call(this, name, "ons-dialog");
            }
            ONSModal.prototype.getAnimation = function () {
                return this.animation;
            };
            ONSModal.prototype.setAnimation = function (animation) {
                this.animation = animation;
                this.setAttribute("animation", animation);
            };
            ONSModal.prototype.getAnimationOptions = function () {
                return this.animationOptions;
            };
            ONSModal.prototype.setAnimationOptions = function (animationOptions) {
                this.animationOptions = animationOptions;
                if (animationOptions != null)
                    this.setAttribute("animation-options", animationOptions.getJavascript());
                else
                    this.setAttribute("animation-options", null);
            };
            return ONSModal;
        }(framework.JSContainer));
        mobile.ONSModal = ONSModal;
        ONSModal["__class"] = "framework.mobile.ONSModal";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSModifiable = (function (_super) {
            __extends(ONSModifiable, _super);
            function ONSModifiable(name, tagName) {
                _super.call(this, name, tagName);
            }
            ONSModifiable.prototype.setModifier = function (modifier) {
                this.setAttribute("modifier", modifier);
            };
            ONSModifiable.prototype.getModifier = function () {
                return this.getAttribute("modifier");
            };
            return ONSModifiable;
        }(framework.JSContainer));
        mobile.ONSModifiable = ONSModifiable;
        ONSModifiable["__class"] = "framework.mobile.ONSModifiable";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSNavigator = (function (_super) {
            __extends(ONSNavigator, _super);
            function ONSNavigator(name) {
                _super.call(this, name, "ons-navigator");
            }
            ONSNavigator.prototype.popPage = function (options) {
            };
            ONSNavigator.prototype.pushPage = function (page, options) {
            };
            ONSNavigator.prototype.replacePage = function (page, options) {
            };
            ONSNavigator.prototype.insertPage = function (index, page, options) {
            };
            ONSNavigator.prototype.resetToPage = function (page, options) {
            };
            ONSNavigator.prototype.bringPageTop = function (item, options) {
            };
            ONSNavigator.prototype.getAnimation = function () {
                return this.animation;
            };
            ONSNavigator.prototype.setAnimation = function (animation) {
                this.animation = animation;
                this.setAttribute("animation", animation);
            };
            ONSNavigator.prototype.getAnimationOptions = function () {
                return this.animationOptions;
            };
            ONSNavigator.prototype.setAnimationOptions = function (animationOptions) {
                this.animationOptions = animationOptions;
                if (animationOptions != null)
                    this.setAttribute("animation-options", animationOptions.getJavascript());
                else
                    this.setAttribute("animation-options", null);
            };
            ONSNavigator.prototype.getPrepush = function () {
                return this.prepush;
            };
            ONSNavigator.prototype.setPrepush = function (prepush) {
                this.prepush = prepush;
                this.addEventListener(prepush, "prepush");
            };
            ONSNavigator.prototype.getPrepop = function () {
                return this.prepop;
            };
            ONSNavigator.prototype.setPrepop = function (prepop) {
                this.prepop = prepop;
                this.addEventListener(prepop, "prepop");
            };
            ONSNavigator.prototype.getPostpush = function () {
                return this.postpush;
            };
            ONSNavigator.prototype.setPostpush = function (postpush) {
                this.postpush = postpush;
                this.addEventListener(postpush, "postpush");
            };
            ONSNavigator.prototype.getPostpop = function () {
                return this.postpop;
            };
            ONSNavigator.prototype.setPostpop = function (postpop) {
                this.postpop = postpop;
                this.addEventListener(postpop, "postpop");
            };
            return ONSNavigator;
        }(framework.JSContainer));
        mobile.ONSNavigator = ONSNavigator;
        ONSNavigator["__class"] = "framework.mobile.ONSNavigator";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSRange = (function (_super) {
            __extends(ONSRange, _super);
            function ONSRange(name) {
                _super.call(this, name, "ons-range");
                this.disabled = false;
            }
            ONSRange.prototype.isDisabled = function () {
                return this.disabled;
            };
            ONSRange.prototype.setDisabled = function (disabled) {
                this.disabled = disabled;
                if (!disabled)
                    this.setAttribute("disabled", null);
                else
                    this.setAttribute("disabled", "true");
            };
            ONSRange.prototype.getValue = function () {
                return this.value;
            };
            ONSRange.prototype.setValue = function (value) {
                this.setAttribute("value", value);
                this.value = value;
            };
            return ONSRange;
        }(framework.JSContainer));
        mobile.ONSRange = ONSRange;
        ONSRange["__class"] = "framework.mobile.ONSRange";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSRipple = (function (_super) {
            __extends(ONSRipple, _super);
            function ONSRipple(name) {
                _super.call(this, name, "ons-ripple");
                this.disabled = false;
            }
            ONSRipple.prototype.isDisabled = function () {
                return this.disabled;
            };
            ONSRipple.prototype.setDisabled = function (disabled) {
                this.disabled = disabled;
                if (disabled) {
                    this.setAttribute("disabled", "true");
                }
                else {
                    this.setAttribute("disabled", null);
                }
            };
            ONSRipple.prototype.getColor = function () {
                return this.color;
            };
            ONSRipple.prototype.setColor = function (color) {
                this.color = color;
                if (color != null) {
                    this.setAttribute("color", "rgba(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "," + color.getAlpha() + ")");
                }
                else {
                    this.setAttribute("color", null);
                }
            };
            ONSRipple.prototype.getBackgroundColor = function () {
                return this.backgroundColor;
            };
            ONSRipple.prototype.setBackgroundColor = function (backgroundColor) {
                this.backgroundColor = backgroundColor;
                if (backgroundColor != null) {
                    this.setAttribute("background-color", "rgba(" + backgroundColor.getRed() + "," + backgroundColor.getGreen() + "," + backgroundColor.getBlue() + "," + backgroundColor.getAlpha() + ")");
                }
                else {
                    this.setAttribute("background-color", null);
                }
            };
            return ONSRipple;
        }(framework.JSContainer));
        mobile.ONSRipple = ONSRipple;
        ONSRipple["__class"] = "framework.mobile.ONSRipple";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSRow = (function (_super) {
            __extends(ONSRow, _super);
            function ONSRow(name) {
                _super.call(this, name, "ons-row");
            }
            ONSRow.prototype.getVerticalAlign = function () {
                return this.verticalAlign;
            };
            ONSRow.prototype.setVerticalAlign = function (verticalAlign) {
                this.verticalAlign = verticalAlign;
                this.setAttribute("vertical-align", verticalAlign);
            };
            return ONSRow;
        }(framework.JSContainer));
        mobile.ONSRow = ONSRow;
        ONSRow["__class"] = "framework.mobile.ONSRow";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSSplitter = (function (_super) {
            __extends(ONSSplitter, _super);
            function ONSSplitter(name) {
                _super.call(this, name, "ons-splitter");
            }
            return ONSSplitter;
        }(framework.JSContainer));
        mobile.ONSSplitter = ONSSplitter;
        ONSSplitter["__class"] = "framework.mobile.ONSSplitter";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSSplitterContent = (function (_super) {
            __extends(ONSSplitterContent, _super);
            function ONSSplitterContent(name) {
                _super.call(this, name, "ons-splitter-content");
            }
            ONSSplitterContent.prototype.getPage = function () {
                return this.page;
            };
            ONSSplitterContent.prototype.setPage = function (page) {
                this.page = page;
                this.setAttribute("page", page);
            };
            return ONSSplitterContent;
        }(framework.JSContainer));
        mobile.ONSSplitterContent = ONSSplitterContent;
        ONSSplitterContent["__class"] = "framework.mobile.ONSSplitterContent";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSSplitterSide = (function (_super) {
            __extends(ONSSplitterSide, _super);
            function ONSSplitterSide(name) {
                _super.call(this, name, "ons-splitter-side");
                this.swipeable = false;
            }
            ONSSplitterSide.prototype.getAnimation = function () {
                return this.animation;
            };
            ONSSplitterSide.prototype.setAnimation = function (animation) {
                this.animation = animation;
                this.setAttribute("animation", animation);
            };
            ONSSplitterSide.prototype.getAnimationOptions = function () {
                return this.animationOptions;
            };
            ONSSplitterSide.prototype.setAnimationOptions = function (animationOptions) {
                this.animationOptions = animationOptions;
                if (animationOptions != null)
                    this.setAttribute("animation-options", animationOptions.getJavascript());
                else
                    this.setAttribute("animation-options", null);
            };
            ONSSplitterSide.prototype.getOpenThreshold = function () {
                return this.openThreshold;
            };
            ONSSplitterSide.prototype.setOpenThreshold = function (openThreshold) {
                this.openThreshold = openThreshold;
                this.setAttribute("open-threshold", openThreshold);
            };
            ONSSplitterSide.prototype.getCollapse = function () {
                return this.collapse;
            };
            ONSSplitterSide.prototype.setCollapse = function (collapse) {
                this.collapse = collapse;
                this.setAttribute("collapse", collapse);
            };
            ONSSplitterSide.prototype.getSwipeTargetWidth = function () {
                return this.swipeTargetWidth;
            };
            ONSSplitterSide.prototype.setSwipeTargetWidth = function (swipeTargetWidth) {
                this.swipeTargetWidth = swipeTargetWidth;
                this.setAttribute("swipe-target-width", swipeTargetWidth);
            };
            ONSSplitterSide.prototype.getWidth = function () {
                return this.width;
            };
            ONSSplitterSide.prototype.setWidth = function (width) {
                this.width = width;
                this.setAttribute("width", width);
            };
            ONSSplitterSide.prototype.getSide = function () {
                return this.side;
            };
            ONSSplitterSide.prototype.setSide = function (side) {
                this.side = side;
                this.setAttribute("side", side);
            };
            ONSSplitterSide.prototype.getMode = function () {
                return this.mode;
            };
            ONSSplitterSide.prototype.setMode = function (mode) {
                this.mode = mode;
                this.setAttribute("mode", mode);
            };
            ONSSplitterSide.prototype.getPage = function () {
                return this.page;
            };
            ONSSplitterSide.prototype.setPage = function (page) {
                this.page = page;
                this.setAttribute("page", page);
            };
            ONSSplitterSide.prototype.isSwipeable = function () {
                return this.swipeable;
            };
            ONSSplitterSide.prototype.setSwipeable = function (swipeable) {
                this.swipeable = swipeable;
                if (swipeable) {
                    this.setAttribute("swipable", "true");
                }
                else {
                    this.setAttribute("swipable", null);
                }
            };
            ONSSplitterSide.prototype.open = function (options) {
            };
            ONSSplitterSide.prototype.close = function (options) {
            };
            ONSSplitterSide.prototype.toggle = function (options) {
            };
            ONSSplitterSide.prototype.load = function (page, options) {
            };
            ONSSplitterSide.prototype.getModechange = function () {
                return this.modechange;
            };
            ONSSplitterSide.prototype.setModechange = function (modechange) {
                this.modechange = modechange;
                this.addEventListener(modechange, "modechange");
            };
            ONSSplitterSide.prototype.getPreopen = function () {
                return this.preopen;
            };
            ONSSplitterSide.prototype.setPreopen = function (preopen) {
                this.preopen = preopen;
                this.addEventListener(preopen, "preopen");
            };
            ONSSplitterSide.prototype.getPostopen = function () {
                return this.postopen;
            };
            ONSSplitterSide.prototype.setPostopen = function (postopen) {
                this.postopen = postopen;
                this.addEventListener(postopen, "postopen");
            };
            ONSSplitterSide.prototype.getPreclose = function () {
                return this.preclose;
            };
            ONSSplitterSide.prototype.setPreclose = function (preclose) {
                this.preclose = preclose;
                this.addEventListener(preclose, "preclose");
            };
            ONSSplitterSide.prototype.getPostclose = function () {
                return this.postclose;
            };
            ONSSplitterSide.prototype.setPostclose = function (postclose) {
                this.postclose = postclose;
                this.addEventListener(postclose, "postclose");
            };
            return ONSSplitterSide;
        }(framework.JSContainer));
        mobile.ONSSplitterSide = ONSSplitterSide;
        ONSSplitterSide["__class"] = "framework.mobile.ONSSplitterSide";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSTab = (function (_super) {
            __extends(ONSTab, _super);
            function ONSTab(name) {
                _super.call(this, name, "ons-tab");
            }
            ONSTab.prototype.getPage = function () {
                return this.page;
            };
            ONSTab.prototype.setPage = function (page) {
                this.page = page;
                this.setAttribute("page", page);
            };
            ONSTab.prototype.getIcon = function () {
                return this.icon;
            };
            ONSTab.prototype.setIcon = function (icon) {
                this.icon = icon;
                this.setAttribute("icon", icon);
            };
            ONSTab.prototype.getActiveIcon = function () {
                return this.activeIcon;
            };
            ONSTab.prototype.setActiveIcon = function (activeIcon) {
                this.activeIcon = activeIcon;
                this.setAttribute("active-icon", activeIcon);
            };
            ONSTab.prototype.getLabel = function () {
                return this.label;
            };
            ONSTab.prototype.setLabel = function (label) {
                this.label = label;
                this.setAttribute("label", label);
            };
            ONSTab.prototype.getBadge = function () {
                return this.badge;
            };
            ONSTab.prototype.setBadge = function (badge) {
                this.badge = badge;
                this.setAttribute("badge", badge);
            };
            ONSTab.prototype.getActive = function () {
                return this.active;
            };
            ONSTab.prototype.setActive = function (active) {
                this.active = active;
                this.setAttribute("active", active);
            };
            return ONSTab;
        }(framework.JSContainer));
        mobile.ONSTab = ONSTab;
        ONSTab["__class"] = "framework.mobile.ONSTab";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSTabbar = (function (_super) {
            __extends(ONSTabbar, _super);
            function ONSTabbar(name) {
                _super.call(this, name, "ons-tabbar");
            }
            ONSTabbar.prototype.getAnimation = function () {
                return this.animation;
            };
            ONSTabbar.prototype.setAnimation = function (animation) {
                this.animation = animation;
                this.setAttribute("animation", animation);
            };
            ONSTabbar.prototype.getAnimationOptions = function () {
                return this.animationOptions;
            };
            ONSTabbar.prototype.setAnimationOptions = function (animationOptions) {
                this.animationOptions = animationOptions;
                if (animationOptions != null)
                    this.setAttribute("animation-options", JSON.stringify(animationOptions));
                else
                    this.setAttribute("animation-options", null);
            };
            ONSTabbar.prototype.getPosition = function () {
                return this.position;
            };
            ONSTabbar.prototype.setPosition = function (position) {
                this.position = position;
                this.setAttribute("position", position);
            };
            ONSTabbar.prototype.setActiveTab = function (index, options) {
            };
            ONSTabbar.prototype.setTabbarVisibility = function (visible) {
            };
            ONSTabbar.prototype.getPrechange = function () {
                return this.prechange;
            };
            ONSTabbar.prototype.setPrechange = function (prechange) {
                this.prechange = prechange;
                this.addEventListener(prechange, "prechange");
            };
            ONSTabbar.prototype.getPostchange = function () {
                return this.postchange;
            };
            ONSTabbar.prototype.setPostchange = function (postchange) {
                this.postchange = postchange;
                this.addEventListener(postchange, "postchange");
            };
            ONSTabbar.prototype.getReactive = function () {
                return this.reactive;
            };
            ONSTabbar.prototype.setReactive = function (reactive) {
                this.reactive = reactive;
                this.addEventListener(reactive, "reactive");
            };
            return ONSTabbar;
        }(framework.JSContainer));
        mobile.ONSTabbar = ONSTabbar;
        ONSTabbar["__class"] = "framework.mobile.ONSTabbar";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSTemplate = (function (_super) {
            __extends(ONSTemplate, _super);
            function ONSTemplate(name) {
                _super.call(this, name, "ons-template");
            }
            return ONSTemplate;
        }(framework.JSContainer));
        mobile.ONSTemplate = ONSTemplate;
        ONSTemplate["__class"] = "framework.mobile.ONSTemplate";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var JSPanel = (function (_super) {
        __extends(JSPanel, _super);
        function JSPanel(name) {
            _super.call(this, name, "jspanel");
            this.addClass("panel");
        }
        return JSPanel;
    }(framework.JSXHTMLFragment));
    framework.JSPanel = JSPanel;
    JSPanel["__class"] = "framework.JSPanel";
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSBackButton = (function (_super) {
            __extends(ONSBackButton, _super);
            function ONSBackButton(name) {
                _super.call(this, name, "ons-back-button");
            }
            return ONSBackButton;
        }(framework.mobile.ONSModifiable));
        mobile.ONSBackButton = ONSBackButton;
        ONSBackButton["__class"] = "framework.mobile.ONSBackButton";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSBottomToolbar = (function (_super) {
            __extends(ONSBottomToolbar, _super);
            function ONSBottomToolbar(name) {
                _super.call(this, name, "ons-bottom-toolbar");
            }
            return ONSBottomToolbar;
        }(framework.mobile.ONSModifiable));
        mobile.ONSBottomToolbar = ONSBottomToolbar;
        ONSBottomToolbar["__class"] = "framework.mobile.ONSBottomToolbar";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSButton = (function (_super) {
            __extends(ONSButton, _super);
            function ONSButton(name) {
                _super.call(this, name, "ons-button");
                this.disabled = false;
            }
            ONSButton.prototype.getRipple = function () {
                return this.ripple;
            };
            ONSButton.prototype.setRipple = function (ripple) {
                this.ripple = ripple;
            };
            ONSButton.prototype.isDisabled = function () {
                return this.disabled;
            };
            ONSButton.prototype.setDisabled = function (disabled) {
                this.disabled = disabled;
                if (!disabled)
                    this.setAttribute("disabled", null);
                else
                    this.setAttribute("disabled", "true");
            };
            return ONSButton;
        }(framework.mobile.ONSModifiable));
        mobile.ONSButton = ONSButton;
        ONSButton["__class"] = "framework.mobile.ONSButton";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSDialog = (function (_super) {
            __extends(ONSDialog, _super);
            function ONSDialog(name, tag) {
                if (((typeof name === 'string') || name === null) && ((typeof tag === 'string') || tag === null)) {
                    var __args = Array.prototype.slice.call(arguments);
                    _super.call(this, name, tag);
                    this.cancelable = false;
                    this.disabled = false;
                }
                else if (((typeof name === 'string') || name === null) && tag === undefined) {
                    var __args = Array.prototype.slice.call(arguments);
                    _super.call(this, name, "ons-dialog");
                    this.cancelable = false;
                    this.disabled = false;
                }
                else
                    throw new Error('invalid overload');
            }
            ONSDialog.prototype.isCancelable = function () {
                return this.cancelable;
            };
            ONSDialog.prototype.setCancelable = function (cancelable) {
                this.cancelable = cancelable;
                if (cancelable) {
                    this.setAttribute("cancelable", "true");
                }
                else {
                    this.setAttribute("cancelable", null);
                }
            };
            ONSDialog.prototype.isDisabled = function () {
                return this.disabled;
            };
            ONSDialog.prototype.setDisabled = function (disabled) {
                this.disabled = disabled;
                if (disabled) {
                    this.setAttribute("disabled", "true");
                }
                else {
                    this.setAttribute("disabled", null);
                }
            };
            ONSDialog.prototype.getAnimation = function () {
                return this.animation;
            };
            ONSDialog.prototype.setAnimation = function (animation) {
                this.animation = animation;
                this.setAttribute("animation", animation);
            };
            ONSDialog.prototype.getAnimationOptions = function () {
                return this.animationOptions;
            };
            ONSDialog.prototype.setAnimationOptions = function (animationOptions) {
                this.animationOptions = animationOptions;
                if (animationOptions != null)
                    this.setAttribute("animation-options", animationOptions.getJavascript());
                else
                    this.setAttribute("animation-options", null);
            };
            ONSDialog.prototype.getMaskColor = function () {
                return this.maskColor;
            };
            ONSDialog.prototype.setMaskColor = function (maskColor) {
                this.maskColor = maskColor;
                if (maskColor != null) {
                    this.setAttribute("mask-color", "rgba(" + maskColor.getRed() + "," + maskColor.getGreen() + "," + maskColor.getBlue() + "," + maskColor.getAlpha() + ")");
                }
                else {
                    this.setAttribute("mask-color", null);
                }
            };
            ONSDialog.prototype.getPreshow = function () {
                return this.preshow;
            };
            ONSDialog.prototype.setPreshow = function (preshow) {
                this.preshow = preshow;
                this.addEventListener(preshow, "preshow");
            };
            ONSDialog.prototype.getPostshow = function () {
                return this.postshow;
            };
            ONSDialog.prototype.setPostshow = function (postshow) {
                this.postshow = postshow;
                this.addEventListener(postshow, "postshow");
            };
            ONSDialog.prototype.getPrehide = function () {
                return this.prehide;
            };
            ONSDialog.prototype.setPrehide = function (prehide) {
                this.prehide = prehide;
                this.addEventListener(prehide, "prehide");
            };
            ONSDialog.prototype.getPosthide = function () {
                return this.posthide;
            };
            ONSDialog.prototype.setPosthide = function (posthide) {
                this.posthide = posthide;
                this.addEventListener(posthide, "posthide");
            };
            ONSDialog.prototype.show = function (options) {
            };
            ONSDialog.prototype.hide = function (options) {
            };
            return ONSDialog;
        }(framework.mobile.ONSModifiable));
        mobile.ONSDialog = ONSDialog;
        ONSDialog["__class"] = "framework.mobile.ONSDialog";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSFab = (function (_super) {
            __extends(ONSFab, _super);
            function ONSFab(name) {
                _super.call(this, name, "ons-fab");
                this.ripple = false;
                this.disabled = false;
            }
            ONSFab.prototype.isDisabled = function () {
                return this.disabled;
            };
            ONSFab.prototype.setDisabled = function (disabled) {
                this.disabled = disabled;
                if (disabled) {
                    this.setAttribute("disabled", "true");
                }
                else {
                    this.setAttribute("disabled", null);
                }
            };
            ONSFab.prototype.isRipple = function () {
                return this.ripple;
            };
            ONSFab.prototype.setRipple = function (ripple) {
                this.ripple = ripple;
                if (ripple) {
                    this.setAttribute("ripple", "true");
                }
                else {
                    this.setAttribute("ripple", null);
                }
            };
            ONSFab.prototype.getPosition = function () {
                return this.position;
            };
            ONSFab.prototype.setPosition = function (position) {
                this.position = position;
                this.setAttribute("position", position);
            };
            return ONSFab;
        }(framework.mobile.ONSModifiable));
        mobile.ONSFab = ONSFab;
        ONSFab["__class"] = "framework.mobile.ONSFab";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSInput = (function (_super) {
            __extends(ONSInput, _super);
            function ONSInput(name) {
                _super.call(this, name, "ons-input");
                this.flt = false;
            }
            ONSInput.prototype.setFloat = function (b) {
                if (b)
                    this.setAttribute("float", "true");
                else
                    this.setAttribute("float", "false");
                this.flt = b;
            };
            ONSInput.prototype.isFloat = function () {
                return this.flt;
            };
            ONSInput.prototype.getPlaceholder = function () {
                return this.placeholder;
            };
            ONSInput.prototype.setPlaceholder = function (placeholder) {
                this.placeholder = placeholder;
                this.setAttribute("placeholder", placeholder);
            };
            ONSInput.prototype.getType = function () {
                return this.type;
            };
            ONSInput.prototype.setType = function (type) {
                this.type = type;
                this.setAttribute("type", type);
            };
            return ONSInput;
        }(framework.mobile.ONSModifiable));
        mobile.ONSInput = ONSInput;
        ONSInput["__class"] = "framework.mobile.ONSInput";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSList = (function (_super) {
            __extends(ONSList, _super);
            function ONSList(name) {
                _super.call(this, name, "ons-list");
            }
            return ONSList;
        }(framework.mobile.ONSModifiable));
        mobile.ONSList = ONSList;
        ONSList["__class"] = "framework.mobile.ONSList";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSListHeader = (function (_super) {
            __extends(ONSListHeader, _super);
            function ONSListHeader(name) {
                _super.call(this, name, "ons-list-header");
            }
            return ONSListHeader;
        }(framework.mobile.ONSModifiable));
        mobile.ONSListHeader = ONSListHeader;
        ONSListHeader["__class"] = "framework.mobile.ONSListHeader";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSListItem = (function (_super) {
            __extends(ONSListItem, _super);
            function ONSListItem(name) {
                _super.call(this, name, "ons-list-item");
                this.lockOnDrag = false;
                this.tappable = false;
            }
            ONSListItem.prototype.isLockOnDrag = function () {
                return this.lockOnDrag;
            };
            ONSListItem.prototype.setLockOnDrag = function (lockOnDrag) {
                this.lockOnDrag = lockOnDrag;
                if (lockOnDrag) {
                    this.setAttribute("lock-on-drag", "true");
                }
                else {
                    this.setAttribute("lock-on-drag", null);
                }
            };
            ONSListItem.prototype.isTappable = function () {
                return this.tappable;
            };
            ONSListItem.prototype.setTappable = function (tappable) {
                this.tappable = tappable;
                if (tappable) {
                    this.setAttribute("tappable", "true");
                }
                else {
                    this.setAttribute("tappable", null);
                }
            };
            ONSListItem.prototype.getTabBackgroundColor = function () {
                return this.tabBackgroundColor;
            };
            ONSListItem.prototype.setTabBackgroundColor = function (tabBackgroundColor) {
                this.tabBackgroundColor = tabBackgroundColor;
                if (tabBackgroundColor != null) {
                    this.setAttribute("tab-backgroundcolor", "rgba(" + tabBackgroundColor.getRed() + "," + tabBackgroundColor.getGreen() + "," + tabBackgroundColor.getBlue() + "," + tabBackgroundColor.getAlpha() + ")");
                }
                else {
                    this.setAttribute("tab-backgroundcolor", null);
                }
            };
            return ONSListItem;
        }(framework.mobile.ONSModifiable));
        mobile.ONSListItem = ONSListItem;
        ONSListItem["__class"] = "framework.mobile.ONSListItem";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSPage = (function (_super) {
            __extends(ONSPage, _super);
            function ONSPage(name) {
                _super.call(this, name, "ons-page");
            }
            ONSPage.prototype.setOnInfiniteScroll = function (EventListener) {
                this.addEventListener(EventListener, "on-infinite-scroll");
                this.onInfiniteScroll_ = EventListener;
                return this;
            };
            ONSPage.prototype.getOnInfiniteScroll = function () {
                return this.onInfiniteScroll_;
            };
            ONSPage.prototype.getInit = function () {
                return this.init;
            };
            ONSPage.prototype.setInit = function (init) {
                this.addEventListener(init, "init");
                this.init = init;
            };
            ONSPage.prototype.getShow = function () {
                return this.show;
            };
            ONSPage.prototype.setShow = function (show) {
                this.addEventListener(show, "show");
                this.show = show;
            };
            ONSPage.prototype.getHide = function () {
                return this.hide;
            };
            ONSPage.prototype.setHide = function (hide) {
                this.addEventListener(hide, "hide");
                this.hide = hide;
            };
            ONSPage.prototype.getDestroy = function () {
                return this.destroy;
            };
            ONSPage.prototype.setDestroy = function (destroy) {
                this.addEventListener(destroy, "destroy");
                this.destroy = destroy;
            };
            return ONSPage;
        }(framework.mobile.ONSModifiable));
        mobile.ONSPage = ONSPage;
        ONSPage["__class"] = "framework.mobile.ONSPage";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSProgressBar = (function (_super) {
            __extends(ONSProgressBar, _super);
            function ONSProgressBar(name, tagName) {
                if (((typeof name === 'string') || name === null) && ((typeof tagName === 'string') || tagName === null)) {
                    var __args = Array.prototype.slice.call(arguments);
                    _super.call(this, name, tagName);
                    this.indeterminate = false;
                }
                else if (((typeof name === 'string') || name === null) && tagName === undefined) {
                    var __args = Array.prototype.slice.call(arguments);
                    _super.call(this, name, "ons-progress-bar");
                    this.indeterminate = false;
                }
                else
                    throw new Error('invalid overload');
            }
            ONSProgressBar.prototype.getValue = function () {
                return this.value;
            };
            ONSProgressBar.prototype.setValue = function (value) {
                this.value = value;
                this.setAttribute("value", value.toString());
            };
            ONSProgressBar.prototype.getSecondaryValue = function () {
                return this.secondaryValue;
            };
            ONSProgressBar.prototype.setSecondaryValue = function (secondaryValue) {
                this.secondaryValue = secondaryValue;
                this.setAttribute("secondary-value", secondaryValue.toString());
            };
            ONSProgressBar.prototype.isIndeterminate = function () {
                return this.indeterminate;
            };
            ONSProgressBar.prototype.setIndeterminate = function (indeterminate) {
                this.indeterminate = indeterminate;
                if (indeterminate) {
                    this.setAttribute("indeterminate", "true");
                }
                else {
                    this.setAttribute("indeterminate", null);
                }
            };
            return ONSProgressBar;
        }(framework.mobile.ONSModifiable));
        mobile.ONSProgressBar = ONSProgressBar;
        ONSProgressBar["__class"] = "framework.mobile.ONSProgressBar";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSToolbar = (function (_super) {
            __extends(ONSToolbar, _super);
            function ONSToolbar(name) {
                _super.call(this, name, "ons-toolbar");
            }
            ONSToolbar.prototype.setInline = function (b) {
                if (b)
                    this.setAttribute("inline", "true");
                else
                    this.setAttribute("inline", null);
            };
            return ONSToolbar;
        }(framework.mobile.ONSModifiable));
        mobile.ONSToolbar = ONSToolbar;
        ONSToolbar["__class"] = "framework.mobile.ONSToolbar";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSToolbarButton = (function (_super) {
            __extends(ONSToolbarButton, _super);
            function ONSToolbarButton(name) {
                _super.call(this, name, "ons-toolbar-button");
            }
            ONSToolbarButton.prototype.setDisabled = function (b) {
                if (b) {
                    this.setAttribute("disabled", "true");
                }
                else {
                    this.setAttribute("disabled", null);
                }
            };
            ONSToolbarButton.prototype.isDisabled = function () {
                return ("true" === this.getAttribute("disabled"));
            };
            return ONSToolbarButton;
        }(framework.mobile.ONSModifiable));
        mobile.ONSToolbarButton = ONSToolbarButton;
        ONSToolbarButton["__class"] = "framework.mobile.ONSToolbarButton";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSAlertDialog = (function (_super) {
            __extends(ONSAlertDialog, _super);
            function ONSAlertDialog(name) {
                _super.call(this, name, "ons-alert-dialog");
            }
            return ONSAlertDialog;
        }(framework.mobile.ONSDialog));
        mobile.ONSAlertDialog = ONSAlertDialog;
        ONSAlertDialog["__class"] = "framework.mobile.ONSAlertDialog";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSPopover = (function (_super) {
            __extends(ONSPopover, _super);
            function ONSPopover(name) {
                _super.call(this, name, "ons-popover");
            }
            ONSPopover.prototype.getDirection = function () {
                return this.direction;
            };
            ONSPopover.prototype.setDirection = function (direction) {
                this.direction = direction;
                this.setAttribute("direction", direction);
            };
            return ONSPopover;
        }(framework.mobile.ONSDialog));
        mobile.ONSPopover = ONSPopover;
        ONSPopover["__class"] = "framework.mobile.ONSPopover";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var app;
(function (app) {
    var CHChimeList = (function (_super) {
        __extends(CHChimeList, _super);
        function CHChimeList(name) {
            _super.call(this, name);
        }
        return CHChimeList;
    }(framework.mobile.ONSList));
    app.CHChimeList = CHChimeList;
    CHChimeList["__class"] = "app.CHChimeList";
})(app || (app = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var app;
(function (app) {
    var CHLogin = (function (_super) {
        __extends(CHLogin, _super);
        function CHLogin() {
            _super.call(this, "Login");
            var logoRow = new framework.mobile.ONSRow("d");
            this.addChild(logoRow);
            this.email = new framework.mobile.ONSInput("email");
            this.email.setPlaceholder("E-mail Address");
            var emailRow = new framework.mobile.ONSRow("dd");
            this.addChild(emailRow);
            emailRow.addChild(this.email);
            var passwordRow = new framework.mobile.ONSRow("dd");
            this.addChild(passwordRow);
            this.password = new framework.mobile.ONSInput("password");
            this.password.setType("password");
            passwordRow.addChild(this.password);
        }
        return CHLogin;
    }(framework.mobile.ONSPage));
    app.CHLogin = CHLogin;
    CHLogin["__class"] = "app.CHLogin";
})(app || (app = {}));
/* Generated from Java with JSweet 1.2.0 - http://www.jsweet.org */
var framework;
(function (framework) {
    var mobile;
    (function (mobile) {
        var ONSProgressBarCircular = (function (_super) {
            __extends(ONSProgressBarCircular, _super);
            function ONSProgressBarCircular(name) {
                _super.call(this, name, "ons-progress-bar-circular");
            }
            return ONSProgressBarCircular;
        }(framework.mobile.ONSProgressBar));
        mobile.ONSProgressBarCircular = ONSProgressBarCircular;
        ONSProgressBarCircular["__class"] = "framework.mobile.ONSProgressBarCircular";
    })(mobile = framework.mobile || (framework.mobile = {}));
})(framework || (framework = {}));
framework.JSContainer.DEFAULT_RENDERER_$LI$();
app.Boot.main(null);
