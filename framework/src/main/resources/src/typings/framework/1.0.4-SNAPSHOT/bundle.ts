/* Generated from Java with JSweet 2.0.0-SNAPSHOT - http://www.jsweet.org */
namespace framework.builder {
    export abstract class AbstractComponentFactory implements framework.builder.model.ComponentFactory {
        /*private*/ impl : string;

        public constructor(impl : string) {
            this.impl = null;
            this.impl = impl;
        }

        /**
         * 
         * @param {string} impl
         * @return {boolean}
         */
        public supports(impl : string) : boolean {
            return /* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(impl,this.impl));
        }

        public abstract createInstance() : framework.JSContainer;

        configureStyles(instance : framework.JSContainer, component : framework.builder.model.Component) {
            let keys : string[] = Object.keys(component.styles);
            for(let index440=0; index440 < keys.length; index440++) {
                let key = keys[index440];
                {
                    let value : string = <string>component.styles[key];
                    instance.setStyle(key, value);
                }
            }
        }

        configureParameters(instance : framework.configs.Designable, component : framework.builder.model.Component) {
            let keys : string[] = Object.keys(component.parameters);
            for(let index441=0; index441 < keys.length; index441++) {
                let key = keys[index441];
                {
                    let value : string = <string>component.parameters[key];
                    instance.setParameter(key, value);
                }
            }
        }

        configureEvents(instance : framework.JSContainer, component : framework.builder.model.Component) {
            for(let index442=0; index442 < component.events.length; index442++) {
                let event = component.events[index442];
                {
                    let listener : framework.builder.BuilderEventListener = new framework.builder.BuilderEventListener(event.source);
                    instance.addEventListener(listener, event.type);
                }
            }
        }

        /**
         * 
         * @param {framework.builder.model.Component} component
         * @return {framework.JSContainer}
         */
        public build(component : framework.builder.model.Component) : framework.JSContainer {
            let instance : framework.JSContainer = this.createInstance();
            this.configureStyles(instance, component);
            this.configureParameters(<framework.configs.Designable><any>instance, component);
            this.configureEvents(instance, component);
            return instance;
        }
    }
    AbstractComponentFactory["__class"] = "framework.builder.AbstractComponentFactory";
    AbstractComponentFactory["__interfaces"] = ["framework.builder.model.ComponentFactory"];


}
namespace framework.builder {
    export class BuilderEventListener implements framework.EventListener {
        /*private*/ jsSource : string;

        public constructor(jsSource : string) {
            this.jsSource = null;
            this.jsSource = jsSource;
        }

        /**
         * 
         * @param {framework.JSContainer} source
         * @param {Event} evt
         */
        public performAction(source : framework.JSContainer, evt : Event) {
            if(this.jsSource != null) {
                eval(this.jsSource);
            }
        }
    }
    BuilderEventListener["__class"] = "framework.builder.BuilderEventListener";
    BuilderEventListener["__interfaces"] = ["framework.EventListener"];


}
namespace framework.builder {
    export interface Editor extends framework.Renderable {
        setComponent(designable : framework.configs.Designable);
    }
}
namespace framework.builder.model {
    export class BuilderEvent {
        public type : string;

        public source : string;

        constructor() {
            this.type = null;
            this.source = null;
        }
    }
    BuilderEvent["__class"] = "framework.builder.model.BuilderEvent";

}
namespace framework.builder.model {
    export class Component {
        public impl : string;

        public parameters : Object = <Object>new Object();

        public children : Array<Component> = <any>(new Array<any>());

        public events : Array<framework.builder.model.BuilderEvent> = <any>(new Array<framework.builder.model.BuilderEvent>());

        public styles : Object = <Object>new Object();

        constructor() {
            this.impl = null;
        }
    }
    Component["__class"] = "framework.builder.model.Component";

}
namespace framework.builder.model {
    export interface ComponentFactory {
        supports(impl : string) : boolean;

        build(component : framework.builder.model.Component) : framework.JSContainer;
    }
}
namespace framework.configs {
    export interface Designable extends framework.Renderable {
        setParameter(key : string, value : string);

        getComponent() : framework.builder.model.Component;

        getParameters() : java.util.List<framework.configs.Parameter>;
    }
}
namespace framework.configs {
    export class Option {
        public constructor(text? : any, value? : any) {
            if(((typeof text === 'string') || text === null) && ((typeof value === 'string') || value === null)) {
                let __args = Array.prototype.slice.call(arguments);
                this.text = null;
                this.value = null;
                this.text = null;
                this.value = null;
                (() => {
                    this.text = text;
                    this.value = value;
                })();
            } else if(text === undefined && value === undefined) {
                let __args = Array.prototype.slice.call(arguments);
                this.text = null;
                this.value = null;
                this.text = null;
                this.value = null;
            } else throw new Error('invalid overload');
        }

        public text : string;

        public value : string;
    }
    Option["__class"] = "framework.configs.Option";

}
namespace framework.configs {
    export class Parameter {
        public constructor(name? : any, label? : any, type? : any) {
            if(((typeof name === 'string') || name === null) && ((typeof label === 'string') || label === null) && ((typeof type === 'string') || type === null)) {
                let __args = Array.prototype.slice.call(arguments);
                this.name = null;
                this.label = null;
                this.type = null;
                this.options = <any>(new java.util.LinkedList<any>());
                this.name = null;
                this.label = null;
                this.type = null;
                (() => {
                    this.name = name;
                    this.label = label;
                    this.type = type;
                })();
            } else if(name === undefined && label === undefined && type === undefined) {
                let __args = Array.prototype.slice.call(arguments);
                this.name = null;
                this.label = null;
                this.type = null;
                this.options = <any>(new java.util.LinkedList<any>());
                this.name = null;
                this.label = null;
                this.type = null;
            } else throw new Error('invalid overload');
        }

        public name : string;

        public label : string;

        public type : string;

        public options : java.util.List<framework.configs.Option> = <any>(new java.util.LinkedList<any>());
    }
    Parameter["__class"] = "framework.configs.Parameter";

}
namespace framework.core {
    export class BasicDecoratorRegistry implements framework.core.DecoratorsRegistry, framework.core.Initializable {
        /*private*/ decorators : java.util.List<framework.core.Decorator> = <any>(new java.util.ArrayList<any>());

        /**
         * 
         * @param {*} decorator
         */
        public registerDecorator(decorator : framework.core.Decorator) {
            this.decorators.add(decorator);
        }

        /**
         * 
         * @return {*}
         */
        public getDecorators() : java.util.List<framework.core.Decorator> {
            return this.decorators;
        }

        /**
         * 
         */
        public doInit() {
            this.registerDecorator(new framework.interactions.InteractionsDecorator());
        }

        constructor() {
        }
    }
    BasicDecoratorRegistry["__class"] = "framework.core.BasicDecoratorRegistry";
    BasicDecoratorRegistry["__interfaces"] = ["framework.core.Initializable","framework.core.DecoratorsRegistry"];


}
namespace framework.core {
    export class BeanFactory {
        static INSTANCE : BeanFactory; public static INSTANCE_$LI$() : BeanFactory { if(BeanFactory.INSTANCE == null) BeanFactory.INSTANCE = new BeanFactory(); return BeanFactory.INSTANCE; };

        /*private*/ beans : java.util.Map<string, any> = <any>(new java.util.HashMap<any, any>());

        public static getInstance() : BeanFactory {
            return BeanFactory.INSTANCE_$LI$();
        }

        onInit(obj : any) {
            if(obj != null && (obj["__interfaces"] != null && obj["__interfaces"].indexOf("framework.core.Initializable") >= 0 || obj.constructor != null && obj.constructor["__interfaces"] != null && obj.constructor["__interfaces"].indexOf("framework.core.Initializable") >= 0)) {
                (<framework.core.Initializable><any>obj).doInit();
            }
        }

        initBeanFactoryAware(bean : any) {
            if(bean != null && (bean["__interfaces"] != null && bean["__interfaces"].indexOf("framework.core.BeanFactoryAware") >= 0 || bean.constructor != null && bean.constructor["__interfaces"] != null && bean.constructor["__interfaces"].indexOf("framework.core.BeanFactoryAware") >= 0)) {
                this.initBeanFactoryAware(<framework.core.BeanFactoryAware><any>bean);
            }
        }

        public addBean(mixing : any, instance : any) {
            let mixxingName : string = mixing.toString();
            this.onInit(instance);
            this.initBeanFactoryAware(instance);
            this.beans.put(mixxingName, instance);
        }

        public getBeanOfType<T>(clazz : any) : T {
            for(let index443=this.beans.keySet().iterator();index443.hasNext();) {
                let key = index443.next();
                {
                    let bean : any = this.beans.get(key);
                    try {
                        if((<any>bean.constructor).isAssignableFrom(clazz)) {
                            return <T>bean;
                        }
                    } catch(e) {
                    };
                }
            }
            let mixing : string = clazz.toString();
            if(this.beans.containsKey(mixing)) {
                return <T>this.beans.get(mixing);
            }
            throw new java.lang.RuntimeException("No bean of type " + /* getName */(c => c["__class"]?c["__class"]:c["name"])(clazz) + " found in factory");
        }

        public getBean(name : string) : any {
            return this.beans.get(name);
        }
    }
    BeanFactory["__class"] = "framework.core.BeanFactory";

}
namespace framework.core {
    export interface BeanFactoryAware {
        setBeanFactory(beanfactory : framework.core.BeanFactory);
    }
}
namespace framework.core {
    export interface Decorator {
        decorate(renderable : framework.Renderable);
    }
}
namespace framework.core {
    export interface DecoratorsRegistry {
        registerDecorator(decorator : framework.core.Decorator);

        getDecorators() : java.util.List<framework.core.Decorator>;
    }
}
namespace framework.core {
    export interface Initializable {
        doInit();
    }
}
namespace framework.core {
    export class Static {
        public static idCount : number = 0;
    }
    Static["__class"] = "framework.core.Static";

}
namespace framework {
    export interface EventListener {
        performAction(source : framework.JSContainer, evt : Event);
    }
}
namespace framework {
    export interface InputField<T> extends framework.Renderable {
        getValue() : T;

        /**
         * 
         * @param {boolean} b
         */
        setValue(b? : any) : any;

        setRawValue(value : string);
    }
}
namespace framework {
    export class InputTypes {
        public static text : string = "text";

        public static password : string = "password";

        public static datetime : string = "datetime";

        public static datetime_local : string = "datetime_local";

        public static date : string = "date";

        public static month : string = "month";

        public static time : string = "time";

        public static week : string = "week";

        public static number : string = "number";

        public static email : string = "email";

        public static url : string = "url";

        public static search : string = "search";

        public static tel : string = "tel";

        public static color : string = "color";

        public static checkbox : string = "checkbox";

        public static radio : string = "radio";
    }
    InputTypes["__class"] = "framework.InputTypes";

}
namespace framework.interactions {
    export interface Draggable extends framework.Renderable {
        getDraggableOptions() : JQueryUI.DraggableOptions;
    }
}
namespace framework.interactions {
    export class DraggableRenderer implements framework.renderer.Renderer<framework.interactions.Draggable> {
        public doRender$framework_interactions_Draggable$jsweet_dom_HTMLElement(c : framework.interactions.Draggable, root : HTMLElement) {
            let jq : JQuery = <JQuery>$("#" + c.getId());
            let opts : JQueryUI.DraggableOptions = c.getDraggableOptions();
            if(opts == null) jq.draggable(); else jq.draggable(opts);
        }

        /**
         * 
         * @param {*} c
         * @param {HTMLElement} root
         */
        public doRender(c? : any, root? : any) : any {
            if(((c != null && (c["__interfaces"] != null && c["__interfaces"].indexOf("framework.interactions.Draggable") >= 0 || c.constructor != null && c.constructor["__interfaces"] != null && c.constructor["__interfaces"].indexOf("framework.interactions.Draggable") >= 0)) || c === null) && ((root != null && root instanceof <any>HTMLElement) || root === null)) {
                return <any>this.doRender$framework_interactions_Draggable$jsweet_dom_HTMLElement(c, root);
            } else throw new Error('invalid overload');
        }

        constructor() {
        }
    }
    DraggableRenderer["__class"] = "framework.interactions.DraggableRenderer";
    DraggableRenderer["__interfaces"] = ["framework.renderer.Renderer"];


}
namespace framework.interactions {
    export interface Droppable extends framework.Renderable {
        getDroppableOptions() : JQueryUI.DroppableOptions;
    }
}
namespace framework.interactions {
    export class DroppableRenderer implements framework.renderer.Renderer<framework.interactions.Droppable> {
        public doRender$framework_interactions_Droppable$jsweet_dom_HTMLElement(c : framework.interactions.Droppable, root : HTMLElement) {
            let jq : JQuery = <JQuery>$("#" + c.getId());
            let opts : JQueryUI.DroppableOptions = c.getDroppableOptions();
            if(opts == null) jq.droppable(); else jq.droppable(opts);
        }

        /**
         * 
         * @param {*} c
         * @param {HTMLElement} root
         */
        public doRender(c? : any, root? : any) : any {
            if(((c != null && (c["__interfaces"] != null && c["__interfaces"].indexOf("framework.interactions.Droppable") >= 0 || c.constructor != null && c.constructor["__interfaces"] != null && c.constructor["__interfaces"].indexOf("framework.interactions.Droppable") >= 0)) || c === null) && ((root != null && root instanceof <any>HTMLElement) || root === null)) {
                return <any>this.doRender$framework_interactions_Droppable$jsweet_dom_HTMLElement(c, root);
            } else throw new Error('invalid overload');
        }

        constructor() {
        }
    }
    DroppableRenderer["__class"] = "framework.interactions.DroppableRenderer";
    DroppableRenderer["__interfaces"] = ["framework.renderer.Renderer"];


}
namespace framework {
    export class Main {
        public static main(args : string[]) {
            framework.core.BeanFactory.getInstance().addBean("framework.core.DecoratorsRegistry", new framework.core.BasicDecoratorRegistry());
            new framework.builder.Builder("builder").render();
        }
    }
    Main["__class"] = "framework.Main";

}
namespace framework {
    export interface Renderable {
        getChangedAttributes() : string[];

        getChangedStyles() : string[];

        getRenderers() : java.util.List<framework.renderer.Renderer<any>>;

        addRenderer(renderer : framework.renderer.Renderer<any>) : Renderable;

        getId() : string;

        uid() : string;

        addClass(styleClass : string) : Renderable;

        removeClass(cls : string) : Renderable;

        addChild(child? : any, layoutData? : any) : any;

        addChildAt(index : number, child : framework.JSContainer) : Renderable;

        setVisible(b : boolean) : Renderable;

        addEventListener(listener : framework.EventListener, type : string) : Renderable;

        getTag() : string;

        setTag(tag : string) : Renderable;

        setStyle(key : string, value : string) : Renderable;

        getStyle(key : string) : string;

        setAttribute(key : string, value : string) : Renderable;

        exec(name? : any, parameter? : any) : any;

        getCommands() : java.lang.Iterable<framework.JSContainer.JSCommand>;

        getAttribute(key : string) : string;

        getName() : string;

        setName(name : string);

        getParent() : Renderable;

        getChildren() : java.util.List<framework.JSContainer>;

        getStyleNames() : java.util.Set<string>;

        getAttributeNames() : java.util.Set<string>;

        getHtml() : string;

        setHtml(h : string) : Renderable;

        isRendered() : boolean;

        setRendered(b : boolean) : Renderable;

        getListeners() : java.util.Map<string, java.util.List<framework.EventListener>>;

        render(root? : any) : any;

        getData() : any;

        setData(data : any);

        /**
         * 
         * @param {string} id
         * @return
         * @return {*}
         */
        getAncestorById(id : string) : Renderable;

        getAncestorByName(name : string) : Renderable;

        getRoot() : Renderable;
    }
}
namespace framework.renderer {
    export class ContainerRenderer implements framework.renderer.Renderer<framework.JSContainer> {
        public decorate(c : framework.JSContainer) {
            for(let index444=framework.core.BeanFactory.getInstance().getBeanOfType<any>("framework.core.DecoratorsRegistry").getDecorators().iterator();index444.hasNext();) {
                let dec = index444.next();
                {
                    dec.decorate(c);
                }
            }
        }

        public doRender$framework_JSContainer$jsweet_dom_HTMLElement(c : framework.JSContainer, root : HTMLElement) {
            let jq : HTMLElement = document.getElementById(c.getId());
            let tag : string = c.getTag();
            let rendered : boolean = c.isRendered();
            let name : string = c.getName();
            let html : string = c.getHtml();
            let parent : framework.Renderable = c.getParent();
            if(!rendered) {
                this.decorate(c);
                if(jq != null) jq.remove();
                let njq : HTMLElement = document.createElement(tag);
                if(name != null && name.length > 0) njq.setAttribute("name", name);
                njq.setAttribute("id", c.getId());
                njq.innerHTML = html;
                this.renderAttributes(njq, c, false);
                this.renderStyles(njq, c, false);
                if(parent == null) {
                    if(root == null) {
                        let body : Node = document.getElementsByTagName("body")[0];
                        body.appendChild(njq);
                    } else {
                        root.appendChild(njq);
                    }
                } else {
                    let index : number = parent.getChildren().indexOf(c);
                    let nextSib : framework.Renderable = null;
                    if(index < parent.getChildren().size() - 1) {
                        nextSib = parent.getChildren().get(index + 1);
                        if(!nextSib.isRendered()) {
                            nextSib = null;
                        }
                    }
                    if(nextSib != null) {
                        let p : Node = document.getElementById(parent.getId());
                        p.insertBefore(njq, document.getElementById(nextSib.getId()));
                    } else {
                        document.getElementById(parent.getId()).appendChild(njq);
                    }
                }
                this.renderEvents(njq, c);
                this.execCommands(njq, c);
                c.flush("a28n12l10");
            } else {
                this.renderAttributes(jq, c, true);
                this.renderStyles(jq, c, true);
                this.execCommands(jq, c);
                c.flush("a28n12l10");
            }
        }

        public doRender(c? : any, root? : any) : any {
            if(((c != null && c instanceof <any>framework.JSContainer) || c === null) && ((root != null && root instanceof <any>HTMLElement) || root === null)) {
                return <any>this.doRender$framework_JSContainer$jsweet_dom_HTMLElement(c, root);
            } else throw new Error('invalid overload');
        }

        execCommands(njq : HTMLElement, container : framework.Renderable) {
            for(let index445=container.getCommands().iterator();index445.hasNext();) {
                let command = index445.next();
                {
                    let name : string = command.getName();
                    let params : Object = command.getParameters();
                    let variable : string = command.getVariable();
                    if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })("null",variable))) {
                        variable = null;
                    }
                    if(params == null && variable == null) {
                        eval("njq." + name + "()");
                    } else if(params != null) {
                        eval("njq." + name + "(params)");
                    } else if(variable != null) {
                        eval("njq." + name + "(" + variable + ")");
                    }
                }
            }
        }

        renderEvents(njq : HTMLElement, c : framework.JSContainer) {
            for(let index446=c.getListeners().keySet().iterator();index446.hasNext();) {
                let key = index446.next();
                {
                    let listeners : java.util.List<framework.EventListener> = c.getListeners().get(key);
                    njq.addEventListener(key, ((listeners) => {
                        return (evt) => {
                            for(let index447=listeners.iterator();index447.hasNext();) {
                                let l = index447.next();
                                {
                                    this.synchronizeFields(njq, c);
                                    l.performAction(c, evt);
                                }
                            }
                            c.getRoot().render();
                        }
                    })(listeners));
                }
            }
        }

        synchronizeFields(njq : HTMLElement, jsfield : framework.Renderable) {
            if(jsfield != null && (jsfield["__interfaces"] != null && jsfield["__interfaces"].indexOf("framework.InputField") >= 0 || jsfield.constructor != null && jsfield.constructor["__interfaces"] != null && jsfield.constructor["__interfaces"].indexOf("framework.InputField") >= 0)) {
                let inputField : framework.InputField<string> = <framework.JSInput><any>jsfield;
                if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(jsfield.getTag(),"input")) && /* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })("checkbox",jsfield.getAttribute("type")))) {
                    let field : HTMLInputElement = <HTMLInputElement>document.getElementById(jsfield.getId());
                    if(field.checked) {
                        inputField.setRawValue("true");
                    } else {
                        inputField.setRawValue("false");
                    }
                } else if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(jsfield.getTag(),"input"))) {
                    let field : HTMLInputElement = <HTMLInputElement>document.getElementById(jsfield.getId());
                    if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })("checkbox",jsfield.getAttribute("type")))) {
                        if(field.checked) {
                            inputField.setRawValue("true");
                        } else {
                            inputField.setRawValue("false");
                        }
                    } else {
                        let value : string = field.value;
                        inputField.setRawValue(value);
                    }
                } else if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(jsfield.getTag(), "select")) {
                    let field : HTMLSelectElement = <HTMLSelectElement>document.getElementById(jsfield.getId());
                    let value : string = field.value;
                    inputField.setRawValue(value);
                } else if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(jsfield.getTag(), "textarea")) {
                    let field : HTMLTextAreaElement = <HTMLTextAreaElement>document.getElementById(jsfield.getId());
                    let value : string = field.value;
                    inputField.setRawValue(value);
                } else {
                    let field : HTMLElement = document.getElementById(jsfield.getId());
                    let value : string = field.getAttribute("value");
                    inputField.setRawValue(value);
                }
            }
            for(let index448=jsfield.getChildren().iterator();index448.hasNext();) {
                let c = index448.next();
                {
                    this.synchronizeFields(document.getElementById(c.getId()), c);
                }
            }
        }

        renderAttributes(njq : HTMLElement, c : framework.Renderable, changed : boolean) {
            if(changed) {
                {
                    let array450 = c.getChangedAttributes();
                    for(let index449=0; index449 < array450.length; index449++) {
                        let key = array450[index449];
                        {
                            if(c.getAttribute(key) == null) {
                                njq.removeAttribute(key);
                            } else {
                                njq.setAttribute(key, c.getAttribute(key));
                            }
                        }
                    }
                }
            } else {
                for(let index451=c.getAttributeNames().iterator();index451.hasNext();) {
                    let key = index451.next();
                    {
                        if(c.getAttribute(key) != null) njq.setAttribute(key, c.getAttribute(key));
                    }
                }
            }
        }

        clearAttributes(elem : HTMLElement) {
            let attrs : NamedNodeMap = elem.attributes;
            for(let i : number = 0; i < attrs.length; i++) {
                if(!/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(attrs[i].name,"id"))) elem.removeAttribute(attrs[i].name);
            };
        }

        clearStyles(jq : HTMLElement) {
            jq.removeAttribute("style");
        }

        renderStyles(njq : HTMLElement, c : framework.Renderable, changed : boolean) {
            if(changed) {
                {
                    let array453 = c.getChangedStyles();
                    for(let index452=0; index452 < array453.length; index452++) {
                        let key = array453[index452];
                        {
                            njq.style.setProperty(key, c.getStyle(key));
                        }
                    }
                }
            } else {
                for(let index454=c.getStyleNames().iterator();index454.hasNext();) {
                    let key = index454.next();
                    {
                        njq.style.setProperty(key, c.getStyle(key));
                    }
                }
            }
        }

        constructor() {
        }
    }
    ContainerRenderer["__class"] = "framework.renderer.ContainerRenderer";
    ContainerRenderer["__interfaces"] = ["framework.renderer.Renderer"];


}
namespace framework.renderer {
    export interface Renderer<T extends framework.Renderable> {
        /**
         * 
         * @param {*} c
         * @param {HTMLElement} root
         */
        doRender(c? : any, root? : any) : any;
    }
}
namespace framework.util {
    /**
     * The Class IOUtil.
     * 
     * @author Kureem Rossaye<br>
     * kureem@gmail.com Oct 22, 2008
     * @class
     */
    export class IOUtil {
        public static getFileContenntAsString$java_io_File$java_lang_String(file : java.io.File, encoding : string) : string {
            let is : java.io.FileInputStream = new java.io.FileInputStream(file);
            return IOUtil.getStreamContentAsString(is);
        }

        /**
         * Gets the file content as string.
         * 
         * @param {java.io.File} file
         * the file
         * @param {string} encoding
         * the encoding
         * @return {string} the file content as string
         * @throws Exception
         * the exception
         */
        public static getFileContenntAsString(file? : any, encoding? : any) : any {
            if(((file != null && file instanceof <any>java.io.File) || file === null) && ((typeof encoding === 'string') || encoding === null)) {
                return <any>framework.util.IOUtil.getFileContenntAsString$java_io_File$java_lang_String(file, encoding);
            } else if(((typeof file === 'string') || file === null) && ((typeof encoding === 'string') || encoding === null)) {
                return <any>framework.util.IOUtil.getFileContenntAsString$java_lang_String$java_lang_String(file, encoding);
            } else if(((file != null && file instanceof <any>java.io.File) || file === null) && encoding === undefined) {
                return <any>framework.util.IOUtil.getFileContenntAsString$java_io_File(file);
            } else if(((typeof file === 'string') || file === null) && encoding === undefined) {
                return <any>framework.util.IOUtil.getFileContenntAsString$java_lang_String(file);
            } else throw new Error('invalid overload');
        }

        public static getFileContenntAsString$java_io_File(file : java.io.File) : string {
            let is : java.io.FileInputStream = new java.io.FileInputStream(file);
            let s : string = <string>new String(IOUtil.getStreamContentAsBytes(is));
            return s;
        }

        public static getFileContenntAsString$java_lang_String$java_lang_String(fileName : string, encoding : string) : string {
            let is : java.io.FileInputStream = new java.io.FileInputStream(fileName);
            return IOUtil.getStreamContentAsString(is);
        }

        public static getFileContenntAsString$java_lang_String(fileName : string) : string {
            let is : java.io.FileInputStream = new java.io.FileInputStream(fileName);
            return <string>new String(IOUtil.getStreamContentAsBytes(is));
        }

        /**
         * Gets the file content as bytes.
         * 
         * @param {string} fileName
         * the file name
         * @return {Array} the file content as bytes
         * @throws Exception
         * the exception
         */
        public static getFileContentAsBytes(fileName : string) : number[] {
            let is : java.io.FileInputStream = new java.io.FileInputStream(fileName);
            return IOUtil.getStreamContentAsBytes(is);
        }

        /**
         * Gets the stream content as string.
         * 
         * @param {java.io.InputStream} is
         * the is
         * @return {string} the stream content as string
         */
        public static getStreamContentAsString(is : java.io.InputStream) : string {
            try {
                let buf : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(is.available());
                is.read(buf);
                let s : string = <string>new String(buf);
                return s;
            } catch(e) {
                throw new java.lang.RuntimeException(e);
            };
        }

        /**
         * Gets the stream content as bytes.
         * 
         * @param {java.io.InputStream} is
         * the is
         * @return {Array} the stream content as bytes
         * @throws Exception
         * the exception
         */
        public static getStreamContentAsBytes(is : java.io.InputStream) : number[] {
            let data : number[] = (s => { let a=[]; while(s-->0) a.push(0); return a; })(is.available());
            if(is.available() === 0) {
                return data;
            }
            is.read(data);
            return data;
        }

        public static writeToFile(content : string, f : java.io.File) : boolean {
            let fout : java.io.FileOutputStream = new java.io.FileOutputStream(f);
            fout.write(/* getBytes */(content).split('').map(s => s.charCodeAt(0)));
            fout.flush();
            fout.close();
            return true;
        }
    }
    IOUtil["__class"] = "framework.util.IOUtil";

}
namespace framework.builder.libraries {
    export class BasicComponentFactory extends framework.builder.AbstractComponentFactory {
        /*private*/ tag : string;

        public constructor(tag : string) {
            super("html:" + tag);
            this.tag = null;
            this.tag = tag;
        }

        /**
         * 
         * @return {framework.JSContainer}
         */
        public createInstance() : framework.JSContainer {
            let container : framework.JSContainer = new framework.JSContainer(this.tag);
            return container;
        }
    }
    BasicComponentFactory["__class"] = "framework.builder.libraries.BasicComponentFactory";
    BasicComponentFactory["__interfaces"] = ["framework.builder.model.ComponentFactory"];


}
namespace framework.interactions {
    export class InteractionsDecorator implements framework.core.Decorator {
        static draggableRenderer : framework.interactions.DraggableRenderer; public static draggableRenderer_$LI$() : framework.interactions.DraggableRenderer { if(InteractionsDecorator.draggableRenderer == null) InteractionsDecorator.draggableRenderer = new framework.interactions.DraggableRenderer(); return InteractionsDecorator.draggableRenderer; };

        static droppableRenderer : framework.interactions.DroppableRenderer; public static droppableRenderer_$LI$() : framework.interactions.DroppableRenderer { if(InteractionsDecorator.droppableRenderer == null) InteractionsDecorator.droppableRenderer = new framework.interactions.DroppableRenderer(); return InteractionsDecorator.droppableRenderer; };

        /**
         * 
         * @param {*} renderable
         */
        public decorate(renderable : framework.Renderable) {
            if(renderable != null && (renderable["__interfaces"] != null && renderable["__interfaces"].indexOf("framework.interactions.Draggable") >= 0 || renderable.constructor != null && renderable.constructor["__interfaces"] != null && renderable.constructor["__interfaces"].indexOf("framework.interactions.Draggable") >= 0)) {
                if(!renderable.getRenderers().contains(InteractionsDecorator.draggableRenderer_$LI$())) {
                    renderable.addRenderer(InteractionsDecorator.draggableRenderer_$LI$());
                }
            }
            if(renderable != null && (renderable["__interfaces"] != null && renderable["__interfaces"].indexOf("framework.interactions.Droppable") >= 0 || renderable.constructor != null && renderable.constructor["__interfaces"] != null && renderable.constructor["__interfaces"].indexOf("framework.interactions.Droppable") >= 0)) {
                if(!renderable.getRenderers().contains(InteractionsDecorator.droppableRenderer_$LI$())) {
                    renderable.addRenderer(InteractionsDecorator.droppableRenderer_$LI$());
                }
            }
        }

        constructor() {
        }
    }
    InteractionsDecorator["__class"] = "framework.interactions.InteractionsDecorator";
    InteractionsDecorator["__interfaces"] = ["framework.core.Decorator"];


}
namespace framework {
    /**
     * 
     * @author Kurreem
     * @param {string} name
     * @param {string} tag
     * @class
     */
    export class JSContainer implements framework.Renderable, framework.configs.Designable {
        /**
         * 
         */
        static DEFAULT_RENDERER : framework.renderer.Renderer<any>; public static DEFAULT_RENDERER_$LI$() : framework.renderer.Renderer<any> { if(JSContainer.DEFAULT_RENDERER == null) JSContainer.DEFAULT_RENDERER = new framework.renderer.ContainerRenderer(); return JSContainer.DEFAULT_RENDERER; };

        /*private*/ listeners : java.util.Map<string, java.util.List<framework.EventListener>> = <any>(new java.util.HashMap<any, any>());

        /*private*/ id : string;

        /*private*/ data : any;

        /*private*/ attributes : java.util.Map<string, string> = <any>(new java.util.HashMap<any, any>());

        /*private*/ styles : java.util.Map<string, string> = <any>(new java.util.HashMap<any, any>());

        /*private*/ parent : JSContainer;

        /*private*/ children : java.util.List<JSContainer> = <any>(new java.util.LinkedList<any>());

        /*private*/ html : string = "";

        /*private*/ tag : string = "";

        /*private*/ name : string = "";

        /*private*/ rendered : boolean = false;

        /*private*/ renderers : java.util.List<framework.renderer.Renderer<any>> = <any>(new java.util.ArrayList<any>());

        /*private*/ changedAttributes : java.util.List<string> = <any>(new java.util.LinkedList<any>());

        /*private*/ changedStyles : java.util.List<string> = <any>(new java.util.LinkedList<any>());

        /*private*/ commands : java.util.List<JSContainer.JSCommand> = <any>(new java.util.LinkedList<any>());

        /*private*/ component : framework.builder.model.Component = new framework.builder.model.Component();

        public constructor(name? : any, tag? : any) {
            if(((typeof name === 'string') || name === null) && ((typeof tag === 'string') || tag === null)) {
                let __args = Array.prototype.slice.call(arguments);
                this.id = null;
                this.data = null;
                this.parent = null;
                this.listeners = <any>(new java.util.HashMap<any, any>());
                this.attributes = <any>(new java.util.HashMap<any, any>());
                this.styles = <any>(new java.util.HashMap<any, any>());
                this.children = <any>(new java.util.LinkedList<any>());
                this.html = "";
                this.tag = "";
                this.name = "";
                this.rendered = false;
                this.renderers = <any>(new java.util.ArrayList<any>());
                this.changedAttributes = <any>(new java.util.LinkedList<any>());
                this.changedStyles = <any>(new java.util.LinkedList<any>());
                this.commands = <any>(new java.util.LinkedList<any>());
                this.component = new framework.builder.model.Component();
                this.id = null;
                this.data = null;
                this.parent = null;
                (() => {
                    this.tag = tag;
                    this.name = name;
                })();
            } else if(((typeof name === 'string') || name === null) && tag === undefined) {
                let __args = Array.prototype.slice.call(arguments);
                let tag : any = __args[0];
                this.id = null;
                this.data = null;
                this.parent = null;
                this.listeners = <any>(new java.util.HashMap<any, any>());
                this.attributes = <any>(new java.util.HashMap<any, any>());
                this.styles = <any>(new java.util.HashMap<any, any>());
                this.children = <any>(new java.util.LinkedList<any>());
                this.html = "";
                this.tag = "";
                this.name = "";
                this.rendered = false;
                this.renderers = <any>(new java.util.ArrayList<any>());
                this.changedAttributes = <any>(new java.util.LinkedList<any>());
                this.changedStyles = <any>(new java.util.LinkedList<any>());
                this.commands = <any>(new java.util.LinkedList<any>());
                this.component = new framework.builder.model.Component();
                this.id = null;
                this.data = null;
                this.parent = null;
                (() => {
                    this.tag = tag;
                })();
            } else throw new Error('invalid overload');
        }

        /**
         * 
         * @return {Array}
         */
        public getChangedAttributes() : string[] {
            return this.changedAttributes.toArray<any>(new Array(this.changedAttributes.size()));
        }

        /**
         * 
         * @return {Array}
         */
        public getChangedStyles() : string[] {
            return this.changedStyles.toArray<any>(new Array(this.changedStyles.size()));
        }

        public flush(s : string) {
            if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(s,"a28n12l10"))) {
                this.changedAttributes.clear();
                this.changedStyles.clear();
                this.commands.clear();
            }
        }

        /**
         * 
         * @return {*}
         */
        public getRenderers() : java.util.List<framework.renderer.Renderer<any>> {
            return this.renderers;
        }

        /**
         * 
         * @param {*} renderer
         * @return {framework.JSContainer}
         */
        public addRenderer(renderer : framework.renderer.Renderer<any>) : JSContainer {
            if(!this.renderers.contains(renderer)) {
                this.renderers.add(renderer);
            }
            return this;
        }

        /**
         * 
         * @return {string}
         */
        public getId() : string {
            if(this.id == null) {
                this.id = this.uid();
            }
            return this.id;
        }

        /**
         * 
         * @return {string}
         */
        public uid() : string {
            framework.core.Static.idCount++;
            return framework.core.Static.idCount + "";
        }

        /**
         * 
         * @param {string} styleClass
         * @return {framework.JSContainer}
         */
        public addClass(styleClass : string) : JSContainer {
            let styles : string = this.getAttribute("class");
            if(styles == null) {
                styles = "";
            }
            let aStyles : string[] = styles.split(" ");
            let add : boolean = true;
            for(let index455=0; index455 < aStyles.length; index455++) {
                let style = aStyles[index455];
                {
                    if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(style.trim(),styleClass))) {
                        add = false;
                    }
                }
            }
            if(add) this.setAttribute("class", styles.trim() + " " + styleClass);
            return this;
        }

        /**
         * 
         * @param {string} cls
         * @return {framework.JSContainer}
         */
        public removeClass(cls : string) : JSContainer {
            let cl : string = this.getAttribute("class");
            if(cl != null && cl.length > 0) {
                cl = /* replace */cl.split(cls).join("");
                this.setAttribute("class", cl);
            }
            return this;
        }

        public addChild(child? : any, layoutData? : any) : any {
            if(((child != null && child instanceof <any>framework.JSContainer) || child === null) && layoutData === undefined) {
                return <any>this.addChild$framework_JSContainer(child);
            } else throw new Error('invalid overload');
        }

        public addChild$framework_JSContainer(container : JSContainer) : JSContainer {
            container.parent = this;
            this.children.add(container);
            return this;
        }

        /**
         * 
         * @param {number} index
         * @param {framework.JSContainer} child
         * @return {framework.JSContainer}
         */
        public addChildAt(index : number, child : JSContainer) : JSContainer {
            child.parent = this;
            this.children.add(index, child);
            return this;
        }

        /**
         * 
         * @param {boolean} b
         * @return {framework.JSContainer}
         */
        public setVisible(b : boolean) : JSContainer {
            if(!b) {
                this.setStyle("display", "none");
            } else {
                this.styles.remove("display");
                this.setRendered(false);
            }
            return this;
        }

        /**
         * 
         * @param {*} listener
         * @param {string} type
         * @return {framework.JSContainer}
         */
        public addEventListener(listener : framework.EventListener, type : string) : JSContainer {
            if(!this.listeners.containsKey(type)) {
                this.listeners.put(type, <any>(new java.util.ArrayList<any>()));
            }
            if(!this.listeners.get(type).contains(listener)) {
                this.listeners.get(type).add(listener);
            }
            return this;
        }

        /**
         * 
         * @return {string}
         */
        public getTag() : string {
            return this.tag;
        }

        /**
         * 
         * @param {string} tag
         * @return {framework.JSContainer}
         */
        public setTag(tag : string) : JSContainer {
            this.tag = tag;
            return this;
        }

        /**
         * 
         * @param {string} key
         * @param {string} value
         * @return {framework.JSContainer}
         */
        public setStyle(key : string, value : string) : JSContainer {
            this.changedStyles.add(key);
            this.styles.put(key, value);
            return this;
        }

        /**
         * 
         * @param {string} key
         * @return {string}
         */
        public getStyle(key : string) : string {
            return this.styles.get(key);
        }

        /**
         * 
         * @param {string} key
         * @param {string} value
         * @return {framework.JSContainer}
         */
        public setAttribute(key : string, value : string) : JSContainer {
            this.changedAttributes.add(key);
            this.attributes.put(key, value);
            return this;
        }

        public exec$java_lang_String$jsweet_lang_Object(name : string, parameter : Object) {
            this.commands.add(new JSContainer.JSCommand(this, name, JSON.stringify(parameter)));
        }

        /**
         * 
         * @param {string} name
         * @param {Object} parameter
         */
        public exec(name? : any, parameter? : any) : any {
            if(((typeof name === 'string') || name === null) && ((parameter != null && parameter instanceof <any>Object) || parameter === null)) {
                return <any>this.exec$java_lang_String$jsweet_lang_Object(name, parameter);
            } else if(((typeof name === 'string') || name === null) && ((typeof parameter === 'string') || parameter === null)) {
                return <any>this.exec$java_lang_String$java_lang_String(name, parameter);
            } else if(((typeof name === 'string') || name === null) && parameter === undefined) {
                return <any>this.exec$java_lang_String(name);
            } else throw new Error('invalid overload');
        }

        public exec$java_lang_String$java_lang_String(name : string, variable : string) {
            this.commands.add(new JSContainer.JSCommand(this, name, variable));
        }

        public exec$java_lang_String(name : string) {
            this.exec$java_lang_String$java_lang_String(name, <string>null);
        }

        /**
         * 
         * @return {*}
         */
        public getCommands() : java.lang.Iterable<JSContainer.JSCommand> {
            return this.commands;
        }

        /**
         * 
         * @param {string} key
         * @return {string}
         */
        public getAttribute(key : string) : string {
            return this.attributes.get(key);
        }

        /**
         * 
         * @return {string}
         */
        public getName() : string {
            return this.name;
        }

        /**
         * 
         * @param {string} name
         */
        public setName(name : string) {
            this.name = name;
        }

        /**
         * 
         * @return {framework.JSContainer}
         */
        public getParent() : JSContainer {
            return this.parent;
        }

        /**
         * 
         * @return {*}
         */
        public getChildren() : java.util.List<JSContainer> {
            return this.children;
        }

        /**
         * 
         * @return {*}
         */
        public getStyleNames() : java.util.Set<string> {
            return this.styles.keySet();
        }

        /**
         * 
         * @return {*}
         */
        public getAttributeNames() : java.util.Set<string> {
            return this.attributes.keySet();
        }

        /**
         * 
         * @return {string}
         */
        public getHtml() : string {
            return this.html;
        }

        /**
         * 
         * @param {string} h
         * @return {framework.JSContainer}
         */
        public setHtml(h : string) : JSContainer {
            this.html = h;
            this.setRendered(false);
            return this;
        }

        /**
         * 
         * @return {boolean}
         */
        public isRendered() : boolean {
            return this.rendered;
        }

        /**
         * 
         * @param {boolean} b
         * @return {framework.JSContainer}
         */
        public setRendered(b : boolean) : JSContainer {
            this.rendered = b;
            if(!b) {
                for(let index456=this.children.iterator();index456.hasNext();) {
                    let child = index456.next();
                    {
                        child.setRendered(b);
                    }
                }
            }
            return this;
        }

        /**
         * 
         * @return {*}
         */
        public getListeners() : java.util.Map<string, java.util.List<framework.EventListener>> {
            return this.listeners;
        }

        public render$() {
            this.render$jsweet_dom_HTMLElement(null);
        }

        public render$jsweet_dom_HTMLElement(parent : HTMLElement) {
            if(this.renderers.isEmpty()) {
                this.renderers.add(JSContainer.DEFAULT_RENDERER_$LI$());
            }
            if(!this.renderers.contains(JSContainer.DEFAULT_RENDERER_$LI$())) {
                this.renderers.add(0, JSContainer.DEFAULT_RENDERER_$LI$());
            }
            for(let index457=this.renderers.iterator();index457.hasNext();) {
                let renderer = index457.next();
                renderer.doRender(this, parent)
            }
            for(let index458=this.getChildren().iterator();index458.hasNext();) {
                let child = index458.next();
                {
                    child.render();
                }
            }
            this.rendered = true;
        }

        /**
         * 
         * @param {HTMLElement} parent
         */
        public render(parent? : any) : any {
            if(((parent != null && parent instanceof <any>HTMLElement) || parent === null)) {
                return <any>this.render$jsweet_dom_HTMLElement(parent);
            } else if(parent === undefined) {
                return <any>this.render$();
            } else throw new Error('invalid overload');
        }

        /**
         * 
         * @return {*}
         */
        public getData() : any {
            return this.data;
        }

        /**
         * 
         * @param {*} data
         */
        public setData(data : any) {
            this.data = data;
        }

        public getAncestorWithClass<T extends JSContainer>(cls : string) : T {
            if(this.parent == null) {
                return null;
            }
            {
                let array460 = this.parent.getAttribute("class").split(" ");
                for(let index459=0; index459 < array460.length; index459++) {
                    let s = array460[index459];
                    {
                        if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(s.trim(),cls))) return <T>this.parent;
                    }
                }
            }
            return <any>((<JSContainer>this.parent).getAncestorWithClass<any>(cls));
        }

        /**
         * 
         * @param {string} id
         * @return {framework.JSContainer}
         */
        public getAncestorById(id : string) : JSContainer {
            if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(this.getId(),id))) return <JSContainer>this;
            if(this.parent == null) {
                return null;
            }
            return this.parent.getAncestorById(id);
        }

        /**
         * 
         * @param {string} name
         * @return {framework.JSContainer}
         */
        public getAncestorByName(name : string) : JSContainer {
            if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(this.getName(),name))) return this;
            if(this.parent == null) {
                return null;
            }
            return this.parent.getAncestorByName(name);
        }

        /**
         * 
         * @return {framework.JSContainer}
         */
        public getRoot() : JSContainer {
            if(this.parent == null) {
                return this;
            } else {
                return this.parent.getRoot();
            }
        }

        /**
         * 
         * @param {string} key
         * @param {string} value
         */
        public setParameter(key : string, value : string) {
        }

        /**
         * 
         * @return {framework.builder.model.Component}
         */
        public getComponent() : framework.builder.model.Component {
            return this.component;
        }

        /**
         * 
         * @return {*}
         */
        public getParameters() : java.util.List<framework.configs.Parameter> {
            return null;
        }
    }
    JSContainer["__class"] = "framework.JSContainer";
    JSContainer["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];



    export namespace JSContainer {

        export class JSCommand {
            public __parent: any;
            name : string;

            parameters : Object;

            variable : string;

            public constructor(__parent: any, name : string, vari : string) {
                this.__parent = __parent;
                this.name = null;
                this.parameters = null;
                this.variable = null;
                __parent.name = name;
                this.variable = vari;
            }

            public getVariable() : string {
                return this.variable;
            }

            public getName() : string {
                return this.__parent.name;
            }

            public setName(name : string) {
                this.__parent.name = name;
            }

            public getParameters() : Object {
                return this.parameters;
            }

            public setParameters(parameters : Object) {
                this.parameters = parameters;
            }
        }
        JSCommand["__class"] = "framework.JSContainer.JSCommand";

    }

}
namespace framework.builder {
    export class Component extends framework.JSContainer implements framework.interactions.Draggable {
        /*private*/ titleFigure : framework.JSContainer = new framework.JSContainer("div").addClass("slds-app-launcher__tile-figure");

        /*private*/ avatar : framework.JSContainer = new framework.JSContainer("span").addClass("slds-avatar slds-avatar_large");

        /*private*/ initial : framework.JSContainer = new framework.JSContainer("abbr").addClass("slds-avatar__initials slds-icon-custom-27");

        /*private*/ title : framework.JSContainer = new framework.JSContainer("span").addClass("slds-app-launcher__title-label");

        public constructor(name : string, initial : string, label : string, factory : framework.builder.model.ComponentFactory) {
            super(name, "div");
            this.addClass("slds-app-launcher__tile");
            this.addChild$framework_JSContainer(this.titleFigure);
            this.titleFigure.addChild$framework_JSContainer(this.avatar);
            this.avatar.addChild$framework_JSContainer(this.initial);
            this.initial.setAttribute("title", label);
            this.initial.setHtml(initial);
            this.titleFigure.addChild$framework_JSContainer(this.title);
            this.title.setHtml(label);
        }

        /**
         * 
         * @return {*}
         */
        public getDraggableOptions() : JQueryUI.DraggableOptions {
            let opts : JQueryUI.DraggableOptions = <any>Object.defineProperty({

            }, '__interfaces', { configurable: true, value: ["def.jqueryui.jqueryui.DraggableOptions","def.jqueryui.jqueryui.DraggableEvents"] });
            opts.appendTo = "body";
            opts.revert = true;
            opts.zIndex = 1000;
            opts.helper = "clone";
            return opts;
        }
    }
    Component["__class"] = "framework.builder.Component";
    Component["__interfaces"] = ["framework.interactions.Draggable","framework.configs.Designable","framework.Renderable"];


}
namespace framework {
    export class JSCheckBox extends framework.JSContainer implements framework.InputField<boolean> {
        public constructor(name : string) {
            super(name, "input");
            this.setAttribute("type", framework.InputTypes.checkbox);
        }

        public setDisabled(b : boolean) : JSCheckBox {
            if(b) {
                this.setAttribute("disabled", "true");
            } else {
                this.setAttribute("disabled", null);
            }
            return this;
        }

        /**
         * 
         * @return {boolean}
         */
        public getValue() : boolean {
            if(this.getAttribute("value") != null && /* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))("true", this.getAttribute("value"))) {
                return true;
            }
            return false;
        }

        public setValue$java_lang_Boolean(b : boolean) {
            if(b) {
                this.setAttribute("value", "true");
                this.setAttribute("checked", "true");
            } else {
                this.setAttribute("value", "false");
                this.setAttribute("checked", null);
            }
        }

        /**
         * 
         * @param {boolean} b
         */
        public setValue(b? : any) : any {
            if(((typeof b === 'boolean') || b === null)) {
                return <any>this.setValue$java_lang_Boolean(b);
            } else throw new Error('invalid overload');
        }

        /**
         * 
         * @param {string} value
         */
        public setRawValue(value : string) {
            this.setAttribute("value", value);
        }

        public isChecked() : boolean {
            return this.getValue();
        }

        public setChecked(b : boolean) {
            this.setValue$java_lang_Boolean(b);
        }
    }
    JSCheckBox["__class"] = "framework.JSCheckBox";
    JSCheckBox["__interfaces"] = ["framework.configs.Designable","framework.InputField","framework.Renderable"];


}
namespace framework {
    export class JSInput extends framework.JSContainer implements framework.InputField<string> {
        public constructor(name : string) {
            super(name, "input");
            this.setType(framework.InputTypes.text);
        }

        public setType(type : string) : JSInput {
            this.setAttribute("type", type.toString());
            return this;
        }

        public setDisabled(b : boolean) : JSInput {
            if(b) {
                this.setAttribute("disabled", "true");
            } else {
                this.setAttribute("disabled", null);
            }
            return this;
        }

        /**
         * 
         * @return {string}
         */
        public getValue() : string {
            return this.getAttribute("value");
        }

        public setValue$java_lang_String(val : string) {
            this.setAttribute("value", val);
        }

        /**
         * 
         * @param {string} val
         */
        public setValue(val? : any) : any {
            if(((typeof val === 'string') || val === null)) {
                return <any>this.setValue$java_lang_String(val);
            } else throw new Error('invalid overload');
        }

        /**
         * 
         * @param {string} value
         */
        public setRawValue(value : string) {
            this.setAttribute("value", value);
        }
    }
    JSInput["__class"] = "framework.JSInput";
    JSInput["__interfaces"] = ["framework.configs.Designable","framework.InputField","framework.Renderable"];


}
namespace framework {
    export class JSOption extends framework.JSContainer {
        public constructor(text : string, value : string) {
            super("option");
            this.setAttribute("value", value);
            this.setHtml(text);
        }

        public getValue() : string {
            return this.getAttribute("value");
        }

        public setValue(value : string) {
            this.setAttribute("value", value);
        }

        public getText() : string {
            return this.getHtml();
        }

        public setText(label : string) {
            this.setHtml(label);
        }

        public setSelected(b : boolean) {
            if(b) {
                this.setAttribute("selected", "true");
            } else {
                this.setAttribute("selected", null);
            }
        }
    }
    JSOption["__class"] = "framework.JSOption";
    JSOption["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework {
    export class JSSelect extends framework.JSContainer implements framework.InputField<string> {
        public constructor(name : string) {
            super(name, "select");
        }

        public addOption(option : framework.JSOption) : JSSelect {
            this.addChild$framework_JSContainer(option);
            return this;
        }

        /**
         * 
         * @return {string}
         */
        public getValue() : string {
            let val : string = this.getAttribute("value");
            for(let index461=this.getChildren().iterator();index461.hasNext();) {
                let opt = index461.next();
                {
                    if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(opt.getAttribute("value"),val))) {
                        return (<framework.JSOption>opt).getValue();
                    }
                }
            }
            return null;
        }

        public setValue$java_lang_String(val : string) {
            for(let index462=this.getChildren().iterator();index462.hasNext();) {
                let opt = index462.next();
                {
                    if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(opt.getAttribute("value"),val))) {
                        (<framework.JSOption>opt).setSelected(true);
                    }
                }
            }
        }

        /**
         * 
         * @param {string} val
         */
        public setValue(val? : any) : any {
            if(((typeof val === 'string') || val === null)) {
                return <any>this.setValue$java_lang_String(val);
            } else throw new Error('invalid overload');
        }

        /**
         * 
         * @param {string} value
         */
        public setRawValue(value : string) {
            this.setAttribute("value", value);
        }
    }
    JSSelect["__class"] = "framework.JSSelect";
    JSSelect["__interfaces"] = ["framework.configs.Designable","framework.InputField","framework.Renderable"];


}
namespace framework {
    export class JSTextArea extends framework.JSContainer implements framework.InputField<string> {
        public constructor(name : string) {
            super(name, "textarea");
        }

        public setDisabled(b : boolean) : JSTextArea {
            if(b) {
                this.setAttribute("disabled", "true");
            } else {
                this.setAttribute("disabled", null);
            }
            return this;
        }

        /**
         * 
         * @return {string}
         */
        public getValue() : string {
            return this.getAttribute("value");
        }

        public setValue$java_lang_String(val : string) {
            this.setAttribute("value", val);
        }

        /**
         * 
         * @param {string} val
         */
        public setValue(val? : any) : any {
            if(((typeof val === 'string') || val === null)) {
                return <any>this.setValue$java_lang_String(val);
            } else throw new Error('invalid overload');
        }

        /**
         * 
         * @param {string} value
         */
        public setRawValue(value : string) {
            this.setAttribute("value", value);
        }
    }
    JSTextArea["__class"] = "framework.JSTextArea";
    JSTextArea["__interfaces"] = ["framework.configs.Designable","framework.InputField","framework.Renderable"];


}
namespace framework.lightning {
    export class Accordion extends framework.JSContainer {
        public constructor(name : string) {
            super(name, "ul");
        }
    }
    Accordion["__class"] = "framework.lightning.Accordion";
    Accordion["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];



    export namespace Accordion {

        export class JSAccordionItem extends framework.JSContainer {
            public __parent: any;
            accordionSection : framework.JSContainer;

            accordionSummary : framework.JSContainer;

            accordionSummaryHeading : framework.JSContainer;

            public constructor(__parent: any, name : string) {
                super(name, "li");
                this.__parent = __parent;
                this.accordionSection = new framework.JSContainer("section").addClass("slds-accordion__section");
                this.accordionSummary = new framework.JSContainer("div").addClass("slds-accordion__summary");
                this.accordionSummaryHeading = new framework.JSContainer("h3").addClass("slds-text-heading_small slds-accordion__summary-heading");
                this.addClass("slds-accordion__list-item");
                this.addChild$framework_JSContainer(this.accordionSection);
                this.accordionSection.addChild$framework_JSContainer(this.accordionSummary);
                this.accordionSummary.addChild$framework_JSContainer(this.accordionSummaryHeading);
            }
        }
        JSAccordionItem["__class"] = "framework.lightning.Accordion.JSAccordionItem";
        JSAccordionItem["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


    }

}
namespace framework.lightning {
    export class Avatar extends framework.JSContainer {
        /*private*/ image : framework.JSContainer = new framework.JSContainer("img");

        public static SMALL : string = "slds-avatar_small";

        public static X_SMALL : string = "slds-avatar_x-small";

        public static MEDIUM : string = "slds-avatar_medium";

        public static LARGE : string = "slds-avatar_large";

        public constructor(name : string) {
            super("span");
            this.addClass("slds-avatar");
            this.addChild$framework_JSContainer(this.image);
        }

        public getImage() : framework.JSContainer {
            return this.image;
        }

        public setSize(size : string) : Avatar {
            this.removeClass(Avatar.LARGE).removeClass(Avatar.MEDIUM).removeClass(Avatar.SMALL).removeClass(Avatar.X_SMALL);
            this.addClass(size);
            return this;
        }

        public setCircle(b : boolean) : Avatar {
            if(b) {
                this.addClass("slds-avatar_circle");
            } else {
                this.removeClass("slds-avatar_circle");
            }
            return this;
        }
    }
    Avatar["__class"] = "framework.lightning.Avatar";
    Avatar["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Badge extends framework.JSContainer {
        public constructor(name : string, tag : string) {
            super(name, tag);
            this.addClass("slds-badge");
        }
    }
    Badge["__class"] = "framework.lightning.Badge";
    Badge["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Box extends framework.JSContainer {
        public static DEFAULT : string = "";

        public static SMALL : string = "slds-box_small";

        public static X_SMALL : string = "slds-box_x-small";

        public static XX_SMALL : string = "slds-box_xx-small";

        public constructor(name : string, tag : string) {
            super(name, tag);
            this.addClass("slds-box");
        }

        public setSize(size : string) : Box {
            return <Box>this.removeClass(Box.DEFAULT).removeClass(Box.SMALL).removeClass(Box.XX_SMALL).removeClass(Box.X_SMALL).addClass(size);
        }
    }
    Box["__class"] = "framework.lightning.Box";
    Box["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class BreadcrumbItem extends framework.JSContainer {
        public constructor(name : string) {
            super("li");
            this.addClass("slds-breadcrumb__item").addClass("slds-text-title_caps");
        }
    }
    BreadcrumbItem["__class"] = "framework.lightning.BreadcrumbItem";
    BreadcrumbItem["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Breadcrumbs extends framework.JSContainer {
        /*private*/ breadcrumb : framework.lightning.HorizontalList = new framework.lightning.HorizontalList("breadcrumb");

        public constructor(name : string) {
            super(name, "nav");
            this.setAttribute("role", "navigation");
            this.setAttribute("aria-label", "Breadcrumbs");
            this.breadcrumb.setTag("ol");
            this.breadcrumb.addClass("slds-wrap");
            this.addChild$framework_JSContainer(this.breadcrumb);
        }

        public addItem$java_lang_String$java_lang_String(name : string, label : string) : Breadcrumbs {
            let item : framework.lightning.BreadcrumbItem = new framework.lightning.BreadcrumbItem("");
            let link : framework.JSContainer = new framework.JSContainer(name, "a");
            link.setAttribute("href", "javascript:void(0);");
            link.setHtml(label);
            item.addChild$framework_JSContainer(link);
            this.breadcrumb.addChild$framework_JSContainer(item);
            return this;
        }

        public addItem(name? : any, label? : any) : any {
            if(((typeof name === 'string') || name === null) && ((typeof label === 'string') || label === null)) {
                return <any>this.addItem$java_lang_String$java_lang_String(name, label);
            } else if(((name != null && name instanceof <any>framework.JSContainer) || name === null) && label === undefined) {
                return <any>this.addItem$framework_JSContainer(name);
            } else throw new Error('invalid overload');
        }

        public addItem$framework_JSContainer(link : framework.JSContainer) : Breadcrumbs {
            let item : framework.lightning.BreadcrumbItem = new framework.lightning.BreadcrumbItem("");
            this.breadcrumb.addChild$framework_JSContainer(item);
            return this;
        }
    }
    Breadcrumbs["__class"] = "framework.lightning.Breadcrumbs";
    Breadcrumbs["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Button extends framework.JSContainer implements framework.configs.Designable {
        static states : string[]; public static states_$LI$() : string[] { if(Button.states == null) Button.states = ["neutral", "brand", "destructive", "success"]; return Button.states; };

        static stateLabels : string[]; public static stateLabels_$LI$() : string[] { if(Button.stateLabels == null) Button.stateLabels = ["Neutral", "Brand", "Destructive", "Success"]; return Button.stateLabels; };

        public static STATE_NEUTRAL : string = "neutral";

        public static STATE_BRAND : string = "brand";

        public static STATE_DESTRUCTIVE : string = "destructive";

        public static STATE_SUCCESS : string = "success";

        /*private*/ __framework_lightning_Button_component : framework.builder.model.Component;

        public constructor(name? : any) {
            if(((typeof name === 'string') || name === null)) {
                let __args = Array.prototype.slice.call(arguments);
                super(name, "button");
                this.__framework_lightning_Button_component = new framework.builder.model.Component();
                (() => {
                    this.addClass("slds-button");
                })();
            } else if(name === undefined) {
                let __args = Array.prototype.slice.call(arguments);
                {
                    let __args = Array.prototype.slice.call(arguments);
                    let name : any = "Button";
                    super(name, "button");
                    this.__framework_lightning_Button_component = new framework.builder.model.Component();
                    (() => {
                        this.addClass("slds-button");
                    })();
                }
            } else throw new Error('invalid overload');
        }

        public addIcon(icon : framework.lightning.Icon) : Button {
            this.addClass("slds-button_icon");
            this.addChild$framework_JSContainer(icon);
            return this;
        }

        public setLabel(label : string) : Button {
            this.setHtml(label);
            return this;
        }

        public setState(state : string) : Button {
            for(let index463=0; index463 < Button.states_$LI$().length; index463++) {
                let s = Button.states_$LI$()[index463];
                {
                    this.removeClass("slds-button_" + s);
                }
            }
            this.addClass("slds-button_" + state);
            return this;
        }

        public setInverse(b : boolean) : Button {
            if(b) {
                this.addClass("slds-button_inverse");
            } else {
                this.removeClass("slds-button_inverse");
            }
            return this;
        }

        public setDisabled(b : boolean) : Button {
            if(b) {
                this.addClass("slds-button_disabled");
            } else {
                this.removeClass("slds-button_disabled");
            }
            return this;
        }

        public setStateful(b : boolean) : Button {
            if(b) {
                this.addClass("slds-button_stateful");
            } else {
                this.removeClass("slds-button_stateful");
            }
            return this;
        }

        public setParameter(key : string, value : string) {
            this.__framework_lightning_Button_component.parameters[key] = value;
            if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(key,"state"))) {
                this.setState(value);
            } else if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(key,"stateful"))) {
                this.setStateful(javaemul.internal.BooleanHelper.parseBoolean(value));
            } else if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(key,"disabled"))) {
                this.setDisabled(javaemul.internal.BooleanHelper.parseBoolean(value));
            } else if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(key,"inverse"))) {
                this.setInverse(javaemul.internal.BooleanHelper.parseBoolean(value));
            } else if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(key,"label"))) {
                this.setLabel(value);
            } else {
                throw new java.lang.RuntimeException("Unknow parameter key:" + value + " Class: framework.lightning.Button");
            }
        }

        public getParameters() : java.util.List<framework.configs.Parameter> {
            let result : java.util.List<framework.configs.Parameter> = <any>(new java.util.ArrayList<any>());
            result.add(this.createParameter("label", "Label", "String"));
            result.add(this.createParameter("stateful", "Stateful", "Boolean"));
            result.add(this.createParameter("disabled", "Disabled", "Boolean"));
            result.add(this.createParameter("inverse", "Inverse", "Boolean"));
            let paramstates : framework.configs.Parameter = this.createParameter("state", "State", "select");
            for(let i : number = 0; i < Button.stateLabels_$LI$().length; i++) {
                let opt : framework.configs.Option = new framework.configs.Option();
                opt.text = Button.stateLabels_$LI$()[i];
                opt.value = Button.states_$LI$()[i];
                paramstates.options.add(opt);
            };
            result.add(paramstates);
            return result;
        }

        /*private*/ createParameter(name : string, label : string, type : string) : framework.configs.Parameter {
            let p : framework.configs.Parameter = new framework.configs.Parameter();
            p.name = name;
            p.type = type;
            p.label = label;
            return p;
        }

        /**
         * 
         * @return {framework.builder.model.Component}
         */
        public getComponent() : framework.builder.model.Component {
            return this.__framework_lightning_Button_component;
        }
    }
    Button["__class"] = "framework.lightning.Button";
    Button["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class ButtonGroup extends framework.JSContainer {
        public constructor(name : string) {
            super(name, "div");
            this.addClass("slds-button-group");
        }

        public addButton$framework_lightning_Button(btn : framework.lightning.Button) : ButtonGroup {
            return this.addElement(btn, false);
        }

        public addButton$framework_lightning_Button$boolean(btn : framework.lightning.Button, isLast : boolean) : ButtonGroup {
            return this.addElement(btn, isLast);
        }

        public addButton(btn? : any, isLast? : any) : any {
            if(((btn != null && btn instanceof <any>framework.lightning.Button) || btn === null) && ((typeof isLast === 'boolean') || isLast === null)) {
                return <any>this.addButton$framework_lightning_Button$boolean(btn, isLast);
            } else if(((btn != null && btn instanceof <any>framework.lightning.IconButton) || btn === null) && ((typeof isLast === 'boolean') || isLast === null)) {
                return <any>this.addButton$framework_lightning_IconButton$boolean(btn, isLast);
            } else if(((btn != null && btn instanceof <any>framework.lightning.Button) || btn === null) && isLast === undefined) {
                return <any>this.addButton$framework_lightning_Button(btn);
            } else if(((btn != null && btn instanceof <any>framework.lightning.IconButton) || btn === null) && isLast === undefined) {
                return <any>this.addButton$framework_lightning_IconButton(btn);
            } else throw new Error('invalid overload');
        }

        public addButton$framework_lightning_IconButton(btn : framework.lightning.IconButton) : ButtonGroup {
            return this.addElement(btn, false);
        }

        public addButton$framework_lightning_IconButton$boolean(btn : framework.lightning.IconButton, isLast : boolean) : ButtonGroup {
            return this.addElement(btn, isLast);
        }

        addElement(c : framework.JSContainer, isLast : boolean) : ButtonGroup {
            if(isLast) {
                c.addClass("slds-button_last");
            } else {
                c.removeClass("slds-button_last");
            }
            this.addChild$framework_JSContainer(c);
            return this;
        }
    }
    ButtonGroup["__class"] = "framework.lightning.ButtonGroup";
    ButtonGroup["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Card extends framework.JSContainer {
        /*private*/ header : framework.lightning.Grid = new framework.lightning.Grid("header", "div");

        /*private*/ headerMedia : framework.lightning.Media = new framework.lightning.Media("headerMedia");

        /*private*/ body : framework.JSContainer = new framework.JSContainer("div").addClass("slds-card__body");

        /*private*/ footer : framework.JSContainer = new framework.JSContainer("footer").addClass("slds-card__footer");

        public constructor(name : string, tag : string) {
            super(name, tag);
            this.addClass("slds-card");
            this.header.addClass("slds-card__header");
            this.header.addChild$framework_JSContainer(this.headerMedia);
            this.addChild$framework_JSContainer(this.header);
            this.addChild$framework_JSContainer(this.body);
            this.addChild$framework_JSContainer(this.footer);
        }

        public getHeader() : framework.lightning.Grid {
            return this.header;
        }

        public getHeaderMedia() : framework.lightning.Media {
            return this.headerMedia;
        }

        public getBody() : framework.JSContainer {
            return this.body;
        }

        public getFooter() : framework.JSContainer {
            return this.footer;
        }
    }
    Card["__class"] = "framework.lightning.Card";
    Card["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class CheckBox extends framework.JSContainer implements framework.InputField<boolean>, framework.EventListener {
        /*private*/ checkbox : framework.JSCheckBox = new framework.JSCheckBox("checkbox");

        /*private*/ checkboxLabel : framework.JSContainer = new framework.JSContainer("checkboxLabel", "label");

        /*private*/ label : framework.JSContainer = new framework.JSContainer("span").addClass("slds-form-element__label");

        public constructor(name : string) {
            super(name, "span");
            this.addClass("slds-checkbox");
            this.addChild$framework_JSContainer(this.checkbox);
            this.checkbox.addClass("slds-assistive-text");
            this.checkboxLabel.addClass("slds-checkbox__label");
            this.addChild$framework_JSContainer(this.checkboxLabel);
            this.checkboxLabel.addChild$framework_JSContainer(new framework.JSContainer("div").addClass("slds-checkbox_faux"));
            this.checkboxLabel.addChild$framework_JSContainer(this.label);
            this.addEventListener(this, "click");
        }

        public setLabel(label : string) : CheckBox {
            this.label.setHtml(label);
            return this;
        }

        /**
         * 
         * @return {boolean}
         */
        public getValue() : boolean {
            return this.getAttribute("checked") != null;
        }

        public setValue$java_lang_Boolean(val : boolean) {
            this.checkbox.setValue$java_lang_Boolean(val);
        }

        /**
         * 
         * @param {boolean} val
         */
        public setValue(val? : any) : any {
            if(((typeof val === 'boolean') || val === null)) {
                return <any>this.setValue$java_lang_Boolean(val);
            } else throw new Error('invalid overload');
        }

        /**
         * 
         * @param {string} value
         */
        public setRawValue(value : string) {
        }

        public toggle() {
            this.checkbox.setValue$java_lang_Boolean(!this.checkbox.getValue());
        }

        /**
         * 
         * @param {*} listener
         * @param {string} type
         * @return {framework.JSContainer}
         */
        public addEventListener(listener : framework.EventListener, type : string) : framework.JSContainer {
            if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(type, "change")) {
                type = "click";
            }
            return super.addEventListener(listener, type);
        }

        /**
         * 
         * @param {framework.JSContainer} source
         * @param {Event} evt
         */
        public performAction(source : framework.JSContainer, evt : Event) {
            this.toggle();
        }
    }
    CheckBox["__class"] = "framework.lightning.CheckBox";
    CheckBox["__interfaces"] = ["framework.EventListener","framework.configs.Designable","framework.InputField","framework.Renderable"];


}
namespace framework.lightning {
    export class CheckBoxButtonGroup extends framework.JSContainer {
        public constructor(name : string) {
            super(name, "div");
            this.addClass("slds-checkbox_button-group");
        }

        public addCheckBoxButton(btn : framework.lightning.CheckBox) : CheckBoxButtonGroup {
            btn.setAttribute("class", "slds-button slds-checkbox_button");
            this.addChild$framework_JSContainer(btn);
            return this;
        }
    }
    CheckBoxButtonGroup["__class"] = "framework.lightning.CheckBoxButtonGroup";
    CheckBoxButtonGroup["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class DockedComposerContainer extends framework.JSContainer {
        public constructor(name : string) {
            super(name, "div");
            this.addClass("slds-docked_container");
        }
    }
    DockedComposerContainer["__class"] = "framework.lightning.DockedComposerContainer";
    DockedComposerContainer["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class FormElement extends framework.JSContainer {
        /*private*/ label : framework.JSContainer = new framework.JSContainer("label", "label").addClass("slds-form-element__label");

        /*private*/ control : framework.JSContainer = new framework.JSContainer("div").addClass("slds-form-element__control");

        public constructor(name : string, tag : string) {
            super(name, tag);
            this.addClass("slds-form-element");
            this.addChild$framework_JSContainer(this.label);
            this.addChild$framework_JSContainer(this.control);
        }

        public setLabel(label : string) : FormElement {
            this.label.setHtml(label);
            return this;
        }

        public setInput(input : framework.InputField<any>) : FormElement {
            this.control.addChild$framework_JSContainer(<framework.JSContainer><any>input);
            return this;
        }

        public getControl() : framework.JSContainer {
            return this.control;
        }
    }
    FormElement["__class"] = "framework.lightning.FormElement";
    FormElement["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Grid extends framework.JSContainer {
        public static PULL_PADDED_XXX_SMALL : string = "";

        public static PULL_PADDED_XX_SMALL : string = "";

        public static PULL_PADDED_X_SMALL : string = "";

        public static PULL_PADDED_SMALL : string = "";

        public static PULL_PADDED_MEDIUM : string = "";

        public static PULL_PADDED_LARGE : string = "";

        public constructor(name : string, tag : string) {
            super(name, tag);
            this.addClass("slds-grid");
        }

        public toggleClass(cls : string, b : boolean) : Grid {
            if(b) {
                this.addClass(cls);
            } else {
                this.removeClass(cls);
            }
            return this;
        }

        public setFrame(b : boolean) : Grid {
            return this.toggleClass("slds-grid_frame", b);
        }

        public setVertical(b : boolean) : Grid {
            return this.toggleClass("slds-grid_vertical", b);
        }

        public setVerticalReverse(b : boolean) : Grid {
            return this.toggleClass("slds-grid_vertical-reverse", b);
        }

        public setReverse(b : boolean) : Grid {
            return this.toggleClass("slds-grid_reverse", b);
        }

        public setPullPadded(b : boolean) : Grid {
            return this.toggleClass("slds-grid_pull-padded", b);
        }

        public setPullPaddedSize(size : string) : Grid {
            this.removeClass(Grid.PULL_PADDED_LARGE).removeClass(Grid.PULL_PADDED_MEDIUM).removeClass(Grid.PULL_PADDED_SMALL).removeClass(Grid.PULL_PADDED_X_SMALL).removeClass(Grid.PULL_PADDED_XX_SMALL).removeClass(Grid.PULL_PADDED_XXX_SMALL).addClass(size);
            return this;
        }

        public setAlignCenter(b : boolean) : Grid {
            return this.toggleClass("slds-grid_align-center", b);
        }

        public setAlignSpace(b : boolean) : Grid {
            return this.toggleClass("slds-grid_align-space", b);
        }

        public setAlignSpead(b : boolean) : Grid {
            return this.toggleClass("slds-grid_align-spread", b);
        }

        public setAlignEnd(b : boolean) : Grid {
            return this.toggleClass("slds-grid_align-end", b);
        }

        public setVerticalAlignStart(b : boolean) : Grid {
            return this.toggleClass("slds-grid_vertical-align-start", b);
        }

        public setVerticalAlignCenter(b : boolean) : Grid {
            return this.toggleClass("slds-grid_vertical-align-center", b);
        }

        public setVerticalAlignEnd(b : boolean) : Grid {
            return this.toggleClass("slds-grid_vertical-align-end", b);
        }

        public setVerticalStretch(b : boolean) : Grid {
            return this.toggleClass("slds-grid_vertical-stretch", b);
        }

        public setNoWrap(b : boolean) : Grid {
            this.toggleClass("slds-nowrap", b);
            return this.toggleClass("slds-wrap", !b);
        }

        public setWrap(b : boolean) : Grid {
            this.toggleClass("slds-wrap", b);
            return this.toggleClass("slds-nowrap", !b);
        }
    }
    Grid["__class"] = "framework.lightning.Grid";
    Grid["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class HorizontalList extends framework.JSContainer {
        public constructor(name : string) {
            super(name, "ul");
            this.addClass("slds-list_horizontal");
        }
    }
    HorizontalList["__class"] = "framework.lightning.HorizontalList";
    HorizontalList["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Icon extends framework.JSContainer {
        public static SMALL : string = "slds-button_icon_small";

        public static EXTRA_SMALL : string = "slds-_icon_x-small";

        public static EXTRA_EXTRA_SMALL : string = "slds-button_icon_xx-small";

        public static LARGE : string = "slds-button_icon_large";

        public static TEXT_DEFAULT : string = "slds-icon-text-default";

        public static TEXT_WARNING : string = "slds-icon-text-warning";

        public static TEXT_ERROR : string = "slds-icon-text-error";

        public static TEXT_LIGHT : string = "slds-icon-text-light";

        /*private*/ assetsUrl : string;

        /*private*/ type : string;

        /*private*/ iconName : string;

        public constructor(name? : any, type? : any, iconName? : any) {
            if(((typeof name === 'string') || name === null) && ((typeof type === 'string') || type === null) && ((typeof iconName === 'string') || iconName === null)) {
                let __args = Array.prototype.slice.call(arguments);
                super(name, "div");
                this.assetsUrl = "/lightning/assets/icons";
                this.type = "utility";
                this.iconName = "settings";
                (() => {
                    this.type = type;
                    this.iconName = iconName;
                    this.refresh();
                })();
            } else if(((typeof name === 'string') || name === null) && type === undefined && iconName === undefined) {
                let __args = Array.prototype.slice.call(arguments);
                super(name, "div");
                this.assetsUrl = "/lightning/assets/icons";
                this.type = "utility";
                this.iconName = "settings";
                (() => {
                    this.refresh();
                })();
            } else throw new Error('invalid overload');
        }

        public refresh() {
            let html : string = "<svg class=\'slds-button__icon\'><use xmlns:xlink=\"http://www.w3.org/1999/xlink\" xlink:href=\"/webjars/lightning/2.3.2/assets/icons/utility-sprite/svg/symbols.svg#settings\"></use></svg>";
            this.setHtml(html);
        }

        public getAssetsUrl() : string {
            return this.assetsUrl;
        }

        public setAssetsUrl(assetsUrl : string) {
            this.assetsUrl = assetsUrl;
            this.refresh();
        }

        public getType() : string {
            return this.type;
        }

        public setType(type : string) {
            this.type = type;
            this.refresh();
        }

        public getIconName() : string {
            return this.iconName;
        }

        public setIconName(name : string) {
            this.iconName = name;
            this.refresh();
        }

        public setSize(size : string) : Icon {
            this.removeClass(Icon.EXTRA_EXTRA_SMALL).removeClass(Icon.EXTRA_SMALL).removeClass(Icon.LARGE).removeClass(Icon.SMALL);
            this.addClass(size);
            return this;
        }

        public setTextType(type : string) : Icon {
            this.removeClass(Icon.TEXT_DEFAULT).removeClass(Icon.TEXT_ERROR).removeClass(Icon.TEXT_LIGHT).removeClass(Icon.TEXT_WARNING).addClass(type);
            return this;
        }
    }
    Icon["__class"] = "framework.lightning.Icon";
    Icon["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class IconButton extends framework.JSContainer {
        /*private*/ icon : framework.lightning.Icon = new framework.lightning.Icon("icon");

        static SMALL : string = "slds-button_icon-small";

        static EXTRA_SMALL : string = "slds-button_icon-x-small";

        static EXTRA_EXTRA_SMALL : string = "slds-button_icon-xx-small";

        public constructor(name : string) {
            super(name, "button");
            this.addChild$framework_JSContainer(this.icon.addClass("slds-button__icon"));
            this.addClass("slds-button").addClass("slds-button_icon");
        }

        public setIcon(icon : framework.lightning.Icon) : IconButton {
            this.getChildren().remove(this.icon);
            this.icon = icon;
            icon.addClass("slds-button__icon");
            this.addChild$framework_JSContainer(icon);
            this.setRendered(false);
            return this;
        }

        public toggleClass(cls : string, b : boolean) : IconButton {
            if(b) {
                this.addClass(cls);
            } else {
                this.removeClass(cls);
            }
            return this;
        }

        public setContainer(b : boolean) : IconButton {
            return this.toggleClass("slds-button_icon-container", b);
        }

        public setBorder(b : boolean) : IconButton {
            return this.toggleClass("slds-button_icon-border", b);
        }

        public setBorderInverse(b : boolean) : IconButton {
            return this.toggleClass("slds-button_icon-border-inverse", b);
        }

        public setBorderFilled(b : boolean) : IconButton {
            return this.toggleClass("slds-button_icon-border-filled", b);
        }

        public setInverse(b : boolean) : IconButton {
            return this.toggleClass("slds-button_icon-inverse", b);
        }

        public setError(b : boolean) : IconButton {
            return this.toggleClass("slds-button_icon-error", b);
        }

        public setSize(size : string) : IconButton {
            this.toggleClass(IconButton.SMALL, false);
            this.toggleClass(IconButton.EXTRA_SMALL, false).toggleClass(IconButton.EXTRA_EXTRA_SMALL, false).toggleClass(size, true);
            return this;
        }

        public setMore(b : boolean) : IconButton {
            return this.toggleClass("slds-button_icon-more", b);
        }

        public setSelected(b : boolean) : IconButton {
            return this.toggleClass("slds-is-selected", b);
        }
    }
    IconButton["__class"] = "framework.lightning.IconButton";
    IconButton["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Lookup extends framework.JSContainer {
        public constructor(name : string) {
            super(name, "div");
            this.addClass("slds-form-element").addClass("slds-lookup");
        }
    }
    Lookup["__class"] = "framework.lightning.Lookup";
    Lookup["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class LTContainer extends framework.JSContainer {
        public static FLOAT_LEFT : string = "slds-float_left";

        public static FLOAT_RIGHT : string = "slds-float_right";

        public static FLOAT_NONE : string = "slds-float_none";

        public constructor(name : string, tag : string) {
            super(name, tag);
        }

        public setFloat(sfloat : string) : LTContainer {
            this.removeClass(LTContainer.FLOAT_LEFT).removeClass(LTContainer.FLOAT_RIGHT).removeClass(LTContainer.FLOAT_NONE);
            this.addClass(sfloat);
            return this;
        }

        toggleClass(cls : string, b : boolean) : LTContainer {
            if(b) {
                this.addClass(cls);
            } else {
                this.removeClass(cls);
            }
            return this;
        }

        public setBorderTop(b : boolean) : LTContainer {
            return this.toggleClass("slds-border_top", b);
        }

        public setBorderBottom(b : boolean) : LTContainer {
            return this.toggleClass("slds-border_bottom", b);
        }

        public setBorderLeft(b : boolean) : LTContainer {
            return this.toggleClass("slds-border_left", b);
        }

        public setBorderRight(b : boolean) : LTContainer {
            return this.toggleClass("slds-border_right", b);
        }

        public setGrow(b : boolean) : LTContainer {
            return this.toggleClass("slds-grow", b);
        }

        public setScrollableY(b : boolean) : LTContainer {
            return this.toggleClass("slds-scrollable_y", b);
        }

        public setScrollableX(b : boolean) : LTContainer {
            return this.toggleClass("slds-scrollable_x", b);
        }

        public setAbsoluteCenter(b : boolean) : LTContainer {
            return this.toggleClass("slds-align_absolute-center", b);
        }
    }
    LTContainer["__class"] = "framework.lightning.LTContainer";
    LTContainer["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Media extends framework.JSContainer {
        /*private*/ figure : framework.JSContainer = new framework.JSContainer("figure", "div").addClass("slds-media__figure");

        /*private*/ body : framework.JSContainer = new framework.JSContainer("div").addClass("slds-media__body");

        public static SIZE_NORMAL : string = "";

        public static SIZE_LARGE : string = "slds-media_large";

        public static SIZE_SMALL : string = "slds-media_small";

        public constructor(name : string) {
            super(name, "div");
            this.addClass("slds-media");
            this.addChild$framework_JSContainer(this.figure);
            this.addChild$framework_JSContainer(this.body);
        }

        public addFigure(figure : framework.JSContainer) : Media {
            this.figure.addChild$framework_JSContainer(figure);
            return this;
        }

        public getFigureContainer() : framework.JSContainer {
            return this.figure;
        }

        public getBodyContainer() : framework.JSContainer {
            return this.body;
        }

        public addBody(body : framework.JSContainer) : Media {
            this.body.addChild$framework_JSContainer(body);
            return this;
        }

        public setSize(size : string) : Media {
            this.removeClass(Media.SIZE_LARGE).removeClass(Media.SIZE_SMALL).addClass(size);
            return this;
        }

        public toggleClass$java_lang_String$boolean(cls : string, b : boolean) : Media {
            return this.toggleClass$java_lang_String$boolean$framework_JSContainer(cls, b, this);
        }

        public toggleClass$java_lang_String$boolean$framework_JSContainer(cls : string, b : boolean, target : framework.JSContainer) : Media {
            if(b) {
                target.addClass(cls);
            } else {
                target.removeClass(cls);
            }
            return this;
        }

        public toggleClass(cls? : any, b? : any, target? : any) : any {
            if(((typeof cls === 'string') || cls === null) && ((typeof b === 'boolean') || b === null) && ((target != null && target instanceof <any>framework.JSContainer) || target === null)) {
                return <any>this.toggleClass$java_lang_String$boolean$framework_JSContainer(cls, b, target);
            } else if(((typeof cls === 'string') || cls === null) && ((typeof b === 'boolean') || b === null) && target === undefined) {
                return <any>this.toggleClass$java_lang_String$boolean(cls, b);
            } else throw new Error('invalid overload');
        }

        public setCentered(b : boolean) : Media {
            return this.toggleClass$java_lang_String$boolean("slds-media_center", b);
        }

        public setFigureReversed(b : boolean) : Media {
            return this.toggleClass$java_lang_String$boolean$framework_JSContainer("slds-media__figure_reverse", b, this.figure);
        }

        public setResponseve(b : boolean) : Media {
            return this.toggleClass$java_lang_String$boolean("slds-media_responsive", b);
        }
    }
    Media["__class"] = "framework.lightning.Media";
    Media["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class TabBody extends framework.JSContainer {
        public constructor(name : string) {
            super(name, "div");
            this.addClass("slds-tabs_default__content");
            this.setAttribute("role", "tabpanel");
        }

        public show(b : boolean) : TabBody {
            if(b) {
                this.removeClass("slds-hide");
                this.addClass("slds-show");
            } else {
                this.removeClass("slds-show");
                this.addClass("slds-hide");
            }
            return this;
        }

        public hide(b : boolean) : TabBody {
            return this.show(!b);
        }
    }
    TabBody["__class"] = "framework.lightning.TabBody";
    TabBody["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class TabItem extends framework.JSContainer implements framework.EventListener {
        public body : framework.lightning.TabBody;

        /*private*/ title : framework.JSContainer = new framework.JSContainer("a").addClass("slds-tabs_default__link").setAttribute("href", "javascript:void(0)").setAttribute("role", "tab");

        public constructor(name : string, body : framework.lightning.TabBody) {
            super(name, "li");
            this.body = null;
            this.body = body;
            body.setAttribute("aria-labelledby", this.getId());
            this.addChild$framework_JSContainer(this.title);
            this.title.setAttribute("aria-controls", body.getId());
            this.addClass("slds-tabs_default__item");
            this.title.addEventListener(this, "click");
            this.setActive(false);
        }

        public setActive(b : boolean) : TabItem {
            if(b) {
                this.addClass("slds-active");
                this.title.setAttribute("aria-selected", "true");
            } else {
                this.removeClass("slds-active");
                this.title.setAttribute("aria-selected", "false");
            }
            this.body.show(b);
            return this;
        }

        public setTitle(title : string) : TabItem {
            this.setAttribute("title", title);
            this.title.setHtml(title);
            return this;
        }

        /**
         * 
         * @param {framework.JSContainer} source
         * @param {Event} evt
         */
        public performAction(source : framework.JSContainer, evt : Event) {
            let tabs : framework.lightning.Tabs = <any>(source.getAncestorWithClass<any>("slds-tabs_default"));
            tabs.setActive(this);
        }
    }
    TabItem["__class"] = "framework.lightning.TabItem";
    TabItem["__interfaces"] = ["framework.EventListener","framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Tabs extends framework.JSContainer {
        /*private*/ nav : framework.JSContainer = new framework.JSContainer("ul").addClass("slds-tabs_default__nav").setAttribute("role", "tablist");

        public constructor(name : string) {
            super(name, "div");
            this.addClass("slds-tabs_default");
            this.addChild$framework_JSContainer(this.nav);
        }

        public addItem(label? : any, list? : any) : any {
            if(((label != null && label instanceof <any>framework.lightning.TabItem) || label === null) && list === undefined) {
                return <any>this.addItem$framework_lightning_TabItem(label);
            } else throw new Error('invalid overload');
        }

        public addItem$framework_lightning_TabItem(item : framework.lightning.TabItem) : Tabs {
            this.nav.addChild$framework_JSContainer(item);
            this.addChild$framework_JSContainer(item.body.show(false));
            return this;
        }

        public setActive(item : framework.lightning.TabItem) : Tabs {
            for(let index464=this.nav.getChildren().iterator();index464.hasNext();) {
                let c = index464.next();
                {
                    let tab : framework.lightning.TabItem = <framework.lightning.TabItem>c;
                    tab.setActive(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(tab,item)));
                }
            }
            item.setActive(true);
            return this;
        }
    }
    Tabs["__class"] = "framework.lightning.Tabs";
    Tabs["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class Text extends framework.JSContainer {
        public constructor(name : string, tag : string) {
            super(name, tag);
        }

        public toggleClass(cls : string, b : boolean) : Text {
            if(b) {
                this.addClass(cls);
            } else {
                this.removeClass(cls);
            }
            return this;
        }

        public setTruncate(b : boolean) : Text {
            return this.toggleClass("slds-truncate", b);
        }
    }
    Text["__class"] = "framework.lightning.Text";
    Text["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.builder {
    export class BasicComponent extends framework.builder.Component {
        public constructor(name : string, initial : string, label : string) {
            super("html:" + name, initial, label, new framework.builder.libraries.BasicComponentFactory(name));
        }
    }
    BasicComponent["__class"] = "framework.builder.BasicComponent";
    BasicComponent["__interfaces"] = ["framework.interactions.Draggable","framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class CheckBoxButton extends framework.lightning.CheckBox {
        public constructor(name : string) {
            super(name);
            this.removeClass("slds-checkbox");
            this.addClass("slds-checkbox_add-button");
        }
    }
    CheckBoxButton["__class"] = "framework.lightning.CheckBoxButton";
    CheckBoxButton["__interfaces"] = ["framework.EventListener","framework.configs.Designable","framework.InputField","framework.Renderable"];


}
namespace framework.builder {
    export class ComponentsLibrary extends framework.lightning.Grid {
        public constructor(name : string) {
            super(name, "ul");
            this.setWrap(true);
            this.setPullPadded(true);
            this.addClass(" slds-library");
        }

        public addComponents(...components : framework.builder.Component[]) : ComponentsLibrary {
            for(let index465=0; index465 < components.length; index465++) {
                let com = components[index465];
                {
                    let li : framework.JSContainer = new framework.JSContainer("li").addClass("slds-p-horizontal_small slds-size_1-of-3");
                    this.addChild$framework_JSContainer(li);
                    li.addChild$framework_JSContainer(com);
                }
            }
            return this;
        }
    }
    ComponentsLibrary["__class"] = "framework.builder.ComponentsLibrary";
    ComponentsLibrary["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class BorderLayout extends framework.lightning.Grid {
        /*private*/ top : framework.JSContainer = new framework.JSContainer("div");

        /*private*/ left : framework.JSContainer = new framework.JSContainer("div");

        /*private*/ center : framework.JSContainer = new framework.JSContainer("div");

        /*private*/ right : framework.JSContainer = new framework.JSContainer("div");

        /*private*/ bottom : framework.JSContainer = new framework.JSContainer("div");

        public constructor(name : string) {
            super(name, "div");
            this.addClass("slds-wrap");
            this.setPullPadded(true);
            this.top.addClass("slds-p-horizontal_small slds-size_1-of-1");
            this.addChild$framework_JSContainer(this.top);
            this.left.addClass("slds-p-horizontal_small slds-size_3-of-12 slds-medium-size_3-of-12 slds-large-size_3-of-12");
            this.addChild$framework_JSContainer(this.left);
            this.center.addClass("slds-p-horizontal_small slds-size_6-of-12 slds-medium-size_6-of-12 slds-large-size_6-of-12");
            this.addChild$framework_JSContainer(this.center);
            this.right.addClass("slds-p-horizontal_small slds-size_3-of-12 slds-medium-size_3-of-12 slds-large-size_3-of-12");
            this.addChild$framework_JSContainer(this.right);
            this.bottom.addClass("slds-p-horizontal_small slds-size_1-of-1");
            this.addChild$framework_JSContainer(this.bottom);
        }

        public addChild$framework_JSContainer$java_lang_String(child : framework.JSContainer, layoutData : string) : BorderLayout {
            if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(layoutData, "left")) {
                this.left.addChild$framework_JSContainer(child);
            } else if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(layoutData, "right")) {
                this.right.addChild$framework_JSContainer(child);
            } else if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(layoutData, "top")) {
                this.top.addChild$framework_JSContainer(child);
            } else if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(layoutData, "bottom")) {
                this.bottom.addChild$framework_JSContainer(child);
            } else if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(layoutData, "center")) {
                this.center.addChild$framework_JSContainer(child);
            }
            return this;
        }

        public addChild(child? : any, layoutData? : any) : any {
            if(((child != null && child instanceof <any>framework.JSContainer) || child === null) && ((typeof layoutData === 'string') || layoutData === null)) {
                return <any>this.addChild$framework_JSContainer$java_lang_String(child, layoutData);
            } else if(((child != null && child instanceof <any>framework.JSContainer) || child === null) && layoutData === undefined) {
                return <any>this.addChild$framework_JSContainer(child);
            } else throw new Error('invalid overload');
        }

        public getTop() : framework.JSContainer {
            return this.top;
        }

        public getLeft() : framework.JSContainer {
            return this.left;
        }

        public getCenter() : framework.JSContainer {
            return this.center;
        }

        public getRight() : framework.JSContainer {
            return this.right;
        }

        public getBottom() : framework.JSContainer {
            return this.bottom;
        }
    }
    BorderLayout["__class"] = "framework.lightning.BorderLayout";
    BorderLayout["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class DockedComposer extends framework.lightning.Grid implements framework.interactions.Draggable {
        /*private*/ header : framework.lightning.Grid = <framework.lightning.Grid>new framework.lightning.Grid("header", "div").addClass("slds-docked-composer__header slds-shrink-none").setAttribute("aria-live", "assertive");

        /*private*/ headerTitle : framework.lightning.Media = new framework.lightning.Media("headerTitle");

        /*private*/ headerIconContainer : framework.JSContainer = new framework.JSContainer("div").addClass("slds-icon_container");

        /*private*/ headerIcon : framework.lightning.Icon = new framework.lightning.Icon("headerIcon").setSize(framework.lightning.Icon.EXTRA_SMALL).setTextType(framework.lightning.Icon.TEXT_DEFAULT);

        /*private*/ title : framework.lightning.Text = new framework.lightning.Text("title", "h2").setTruncate(true);

        /*private*/ tools : framework.JSContainer = new framework.JSContainer("div").addClass("slds-col_bump-left slds-shrink-none");

        /*private*/ minimize : framework.lightning.IconButton = new framework.lightning.IconButton("minimize");

        /*private*/ expand : framework.lightning.IconButton = new framework.lightning.IconButton("expand");

        /*private*/ close : framework.lightning.IconButton = new framework.lightning.IconButton("close");

        /*private*/ body : framework.JSContainer = new framework.JSContainer("div").addClass("slds-docked-composer__body");

        /*private*/ footer : framework.JSContainer = new framework.JSContainer("footer").addClass("slds-docked-composer__footer slds-shrink-none");

        public constructor(name : string) {
            super(name, "section");
            this.setVertical(true);
            this.setAttribute("role", "dialog");
            this.setOpen(true);
            this.addChild$framework_JSContainer(this.header);
            this.header.addChild$framework_JSContainer(this.headerTitle);
            this.headerTitle.getFigureContainer().addClass("slds-m-right_x-small");
            this.headerTitle.setCentered(true);
            this.headerTitle.getFigureContainer().addChild$framework_JSContainer(this.headerIconContainer);
            this.headerIconContainer.addChild$framework_JSContainer(this.headerIcon);
            this.headerTitle.getBodyContainer().addChild$framework_JSContainer(this.title);
            this.header.addChild$framework_JSContainer(this.tools);
            this.tools.addChild$framework_JSContainer(this.minimize).addChild$framework_JSContainer(this.expand).addChild$framework_JSContainer(this.close);
            this.addChild$framework_JSContainer(this.body);
            this.addChild$framework_JSContainer(this.footer);
            this.addClass("slds-docked-composer");
        }

        public setOpen(b : boolean) : DockedComposer {
            this.toggleClass("slds-is-open", b);
            this.toggleClass("slds-is-closed", !b);
            return this;
        }

        public setClosed(b : boolean) : DockedComposer {
            this.toggleClass("slds-is-closed", b);
            this.toggleClass("slds-is-open", !b);
            return this;
        }

        public getHeaderIcon() : framework.lightning.Icon {
            return this.headerIcon;
        }

        public getTitle() : framework.lightning.Text {
            return this.title;
        }

        public getTools() : framework.JSContainer {
            return this.tools;
        }

        public getExpandButton() : framework.lightning.IconButton {
            return this.expand;
        }

        public getCloseButton() : framework.lightning.IconButton {
            return this.close;
        }

        public getBody() : framework.JSContainer {
            return this.body;
        }

        public getFooter() : framework.JSContainer {
            return this.footer;
        }

        public setFocus(b : boolean) : DockedComposer {
            this.toggleClass("slds-has-focus", b);
            return this;
        }

        public setFormBody(b : boolean) : DockedComposer {
            if(b) {
                this.body.addClass("slds-docked-composer__body_form");
            } else {
                this.body.removeClass("slds-docked-composer__body_form");
            }
            return this;
        }

        public setBodyEmailComposer(b : boolean) : DockedComposer {
            if(b) {
                this.body.addClass("slds-docked-composer__body_form");
            } else {
                this.body.removeClass("slds-docked-composer__body_form");
            }
            return this;
        }

        public setOverflow(b : boolean) : DockedComposer {
            this.toggleClass("slds-docked-composer_overflow", b);
            return this;
        }

        /**
         * 
         * @return {*}
         */
        public getDraggableOptions() : JQueryUI.DraggableOptions {
            let o : JQueryUI.DraggableOptions = <any>Object.defineProperty({

            }, '__interfaces', { configurable: true, value: ["def.jqueryui.jqueryui.DraggableOptions","def.jqueryui.jqueryui.DraggableEvents"] });
            o.handle = "#" + this.header.getId();
            return o;
        }
    }
    DockedComposer["__class"] = "framework.lightning.DockedComposer";
    DockedComposer["__interfaces"] = ["framework.interactions.Draggable","framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class GlobalHeader extends framework.lightning.Grid {
        public constructor(name : string) {
            super(name, "div");
            this.setAlignSpead(true);
            this.addClass("slds-global-header");
        }
    }
    GlobalHeader["__class"] = "framework.lightning.GlobalHeader";
    GlobalHeader["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];



    export namespace GlobalHeader {

        export abstract class GlobalHeaderItem extends framework.JSContainer {
            public __parent: any;
            public constructor(__parent: any, name : string, tag : string) {
                super(name, tag);
                this.__parent = __parent;
                this.addClass("slds-global-header__item");
            }
        }
        GlobalHeaderItem["__class"] = "framework.lightning.GlobalHeader.GlobalHeaderItem";
        GlobalHeaderItem["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];



        export class SearchGlobalHeaderItem extends GlobalHeader.GlobalHeaderItem {
            public __parent: any;
            public constructor(__parent: any, name : string) {
                super(__parent, name, "div");
                this.__parent = __parent;
                this.addClass("slds-global-header__item_search");
            }
        }
        SearchGlobalHeaderItem["__class"] = "framework.lightning.GlobalHeader.SearchGlobalHeaderItem";
        SearchGlobalHeaderItem["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


    }

}
namespace framework.lightning {
    export class Panel extends framework.lightning.Grid {
        /*private*/ layout : framework.lightning.FormLayout = new framework.lightning.FormLayout("layout", "div");

        public constructor(name : string) {
            super(name, "div");
            this.setNoWrap(true).setVertical(true);
            this.layout.setStacked(true);
            this.addChild$framework_JSContainer(this.layout);
        }

        public getLayout() : framework.lightning.FormLayout {
            return this.layout;
        }

        public addSection(section : Panel.PanelSection) : Panel {
            this.layout.addChild$framework_JSContainer(section);
            return this;
        }
    }
    Panel["__class"] = "framework.lightning.Panel";
    Panel["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];



    export namespace Panel {

        export class PanelSection extends framework.JSContainer {
            public __parent: any;
            public constructor(__parent: any, name : string, tag : string) {
                super(name, tag);
                this.__parent = __parent;
                this.addClass("slds-panel__section");
            }
        }
        PanelSection["__class"] = "framework.lightning.Panel.PanelSection";
        PanelSection["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


    }

}
namespace framework.builder {
    export class Builder extends framework.lightning.LTContainer {
        /*private*/ globalHeader : framework.lightning.GlobalHeader = new framework.lightning.GlobalHeader("header");

        /*private*/ propertiesDockedComposer : framework.lightning.DockedComposer = new framework.lightning.DockedComposer("properties");

        /*private*/ borderLayout : framework.lightning.BorderLayout = new framework.lightning.BorderLayout("borderLayout");

        /*private*/ mainEditor : framework.builder.EditorTabs = new framework.builder.EditorTabs("mainEditor");

        /*private*/ basicEditorBody : framework.builder.Editor = new framework.builder.BasicPropertiesEditorBody("basic");

        /*private*/ advancedPropertiesEditorBody : framework.builder.Editor = new framework.builder.AdvancedPropertiesEditorBody();

        /*private*/ eventEditor : framework.builder.Editor = new framework.builder.EventsEditor();

        /*private*/ libraryDockedComposer : framework.lightning.DockedComposer = new framework.lightning.DockedComposer("library");

        /*private*/ basicComponentLib : framework.builder.libraries.BasicComponentLibrary = new framework.builder.libraries.BasicComponentLibrary();

        /*private*/ lightningComponentLib : framework.builder.libraries.LightningComponentLibrary = new framework.builder.libraries.LightningComponentLibrary();

        /*private*/ componentsTabs : framework.builder.ComponentsTabs = new framework.builder.ComponentsTabs("componentsTabs");

        public constructor(name : string) {
            super(name, "div");
            this.addChild$framework_JSContainer(this.borderLayout);
            let actions : framework.lightning.ButtonGroup = new framework.lightning.ButtonGroup("actions");
            actions.addButton$framework_lightning_Button(new framework.lightning.Button("new").setLabel("New").setState(framework.lightning.Button.STATE_NEUTRAL));
            actions.addButton$framework_lightning_Button(new framework.lightning.Button("edit").setLabel("Edit").setState(framework.lightning.Button.STATE_NEUTRAL));
            this.borderLayout.addChild$framework_JSContainer$java_lang_String(this.globalHeader, "top");
            this.globalHeader.addChild$framework_JSContainer(actions);
            this.borderLayout.addChild$framework_JSContainer$java_lang_String(this.propertiesDockedComposer, "left");
            this.propertiesDockedComposer.getTitle().setHtml("Properties");
            this.mainEditor.addItem$java_lang_String$framework_builder_Editor("Basic", this.basicEditorBody).setActive(true);
            this.mainEditor.addItem$java_lang_String$framework_builder_Editor("Advanced", this.advancedPropertiesEditorBody).setActive(false);
            this.mainEditor.addItem$java_lang_String$framework_builder_Editor("Events", this.eventEditor).setActive(false);
            let btn : framework.lightning.Button = new framework.lightning.Button();
            btn.setLabel("Click me");
            this.borderLayout.addChild$framework_JSContainer$java_lang_String(btn, "center");
            this.basicEditorBody.setComponent(btn);
            this.advancedPropertiesEditorBody.setComponent(btn);
            this.eventEditor.setComponent(btn);
            this.propertiesDockedComposer.getBody().addChild$framework_JSContainer(this.mainEditor);
            this.dockLeftPanel(true);
            this.libraryDockedComposer.getTitle().setHtml("Components Library");
            this.borderLayout.addChild$framework_JSContainer$java_lang_String(this.libraryDockedComposer, "right");
            this.libraryDockedComposer.getBody().addChild$framework_JSContainer(this.componentsTabs);
            this.componentsTabs.addItem$java_lang_String$framework_builder_ComponentsLibrary("Basic", this.basicComponentLib);
            this.componentsTabs.addItem$java_lang_String$framework_builder_ComponentsLibrary("Lightning", this.lightningComponentLib);
            this.dockRightPanel(true);
        }

        public dockLeftPanel(b : boolean) {
            if(b) {
                this.borderLayout.getLeft().addClass("slds-docked_container");
            } else {
                this.borderLayout.getLeft().removeClass("slds-docked_container");
            }
        }

        public dockRightPanel(b : boolean) {
            if(b) {
                this.borderLayout.getRight().addClass("slds-docked_container");
                this.borderLayout.getRight().setStyle("right", "380px");
            } else {
                this.borderLayout.getRight().removeClass("slds-docked_container");
            }
        }
    }
    Builder["__class"] = "framework.builder.Builder";
    Builder["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class DescriptionList extends framework.lightning.LTContainer {
        public static DEFAULT : string = "";

        public static INLINE : string = "slds-dl_inline";

        public static HORIZONTAL : string = "slds-dl_horizontal";

        /*private*/ currentLayout : string = DescriptionList.DEFAULT;

        public constructor(name : string) {
            super(name, "dl");
        }

        public setLayout(layout : string) : DescriptionList {
            this.currentLayout = layout;
            this.removeClass(DescriptionList.INLINE).removeClass(DescriptionList.HORIZONTAL);
            for(let index466=this.getChildren().iterator();index466.hasNext();) {
                let child = index466.next();
                {
                    child.removeClass(DescriptionList.INLINE + "__label").removeClass(DescriptionList.INLINE + "__detail");
                    child.removeClass(DescriptionList.HORIZONTAL + "__label").removeClass(DescriptionList.HORIZONTAL + "__detail");
                    if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(child.getTag(),"dt"))) {
                        child.addClass(layout + "__label");
                    } else {
                        child.addClass(layout + "__detail");
                    }
                }
            }
            return this;
        }

        public addItem(label : string, item : framework.JSContainer) : DescriptionList {
            let dt : framework.JSContainer = new framework.JSContainer("dt").setHtml(label);
            this.addChild$framework_JSContainer(dt);
            let detail : framework.JSContainer = new framework.JSContainer("dd").addChild$framework_JSContainer(item);
            this.addChild$framework_JSContainer(detail);
            this.setLayout(this.currentLayout);
            return this;
        }
    }
    DescriptionList["__class"] = "framework.lightning.DescriptionList";
    DescriptionList["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.lightning {
    export class FormLayout extends framework.lightning.LTContainer {
        public constructor(name : string, tag : string) {
            super(name, tag);
            this.addClass("slds-form");
        }

        toggleClass(cls : string, b : boolean) : FormLayout {
            return <FormLayout>super.toggleClass(cls, b);
        }

        public setStacked(b : boolean) : FormLayout {
            this.toggleClass("slds-form_stacked", b);
            if(b) {
                this.setInline(false);
                this.setHorizontal(false);
                this.setCompound(false);
            }
            return this;
        }

        public setInline(b : boolean) : FormLayout {
            this.toggleClass("slds-form_inline", b);
            if(b) {
                this.setStacked(false);
                this.setHorizontal(false);
                this.setCompound(false);
            }
            return this;
        }

        public setCompound(b : boolean) : FormLayout {
            this.toggleClass("slds-form_compound", b);
            if(b) {
                this.setInline(false);
                this.setHorizontal(false);
                this.setStacked(false);
            }
            return this;
        }

        public setHorizontal(b : boolean) : FormLayout {
            this.toggleClass("slds-form_horizontal", b);
            if(b) {
                this.setInline(false);
                this.setStacked(false);
                this.setCompound(false);
            }
            return this;
        }

        public addFormElement(element : framework.lightning.FormElement) : FormLayout {
            this.addChild$framework_JSContainer(element);
            return this;
        }

        public clear() : FormLayout {
            this.getChildren().clear();
            this.setRendered(false);
            return this;
        }
    }
    FormLayout["__class"] = "framework.lightning.FormLayout";
    FormLayout["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.builder {
    export class ComponentsTabs extends framework.lightning.Tabs {
        public constructor(name : string) {
            super(name);
            this.addClass("slds-tabs_compact");
        }

        public addItem$java_lang_String$framework_builder_ComponentsLibrary(label : string, list : framework.builder.ComponentsLibrary) : ComponentsTabs {
            let body : framework.lightning.TabBody = new framework.lightning.TabBody("body");
            body.addChild$framework_JSContainer(list);
            let item : framework.lightning.TabItem = new framework.lightning.TabItem("TabItem", body);
            item.setTitle(label);
            this.addItem$framework_lightning_TabItem(item);
            return this;
        }

        public addItem(label? : any, list? : any) : any {
            if(((typeof label === 'string') || label === null) && ((list != null && list instanceof <any>framework.builder.ComponentsLibrary) || list === null)) {
                return <any>this.addItem$java_lang_String$framework_builder_ComponentsLibrary(label, list);
            } else if(((label != null && label instanceof <any>framework.lightning.TabItem) || label === null) && list === undefined) {
                return <any>this.addItem$framework_lightning_TabItem(label);
            } else throw new Error('invalid overload');
        }

        public addComponentList(label : string, ...components : framework.builder.Component[]) : ComponentsTabs {
            let body : framework.lightning.TabBody = new framework.lightning.TabBody("body");
            let list : framework.builder.ComponentsLibrary = new framework.builder.ComponentsLibrary("list");
            (o => o.addComponents.apply(o, components))(list);
            body.addChild$framework_JSContainer(list);
            let item : framework.lightning.TabItem = new framework.lightning.TabItem("TabItem", body);
            item.setTitle(label);
            this.addItem$framework_lightning_TabItem(item);
            return this;
        }
    }
    ComponentsTabs["__class"] = "framework.builder.ComponentsTabs";
    ComponentsTabs["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.builder {
    export class EditorTabs extends framework.lightning.Tabs {
        public constructor(name : string) {
            super(name);
            this.addClass("slds-tabs_compact");
        }

        public addItem$java_lang_String$framework_builder_Editor(label : string, editor : framework.builder.Editor) : framework.lightning.TabItem {
            let body : framework.lightning.TabBody = new framework.lightning.TabBody("edi");
            body.addChild$framework_JSContainer(<framework.JSContainer><any>editor);
            let item : framework.lightning.TabItem = new framework.lightning.TabItem("tabItem_" + editor.getName(), body).setTitle(label);
            this.addItem$framework_lightning_TabItem(item);
            return item;
        }

        public addItem(label? : any, editor? : any) : any {
            if(((typeof label === 'string') || label === null) && ((editor != null && (editor["__interfaces"] != null && editor["__interfaces"].indexOf("framework.builder.Editor") >= 0 || editor.constructor != null && editor.constructor["__interfaces"] != null && editor.constructor["__interfaces"].indexOf("framework.builder.Editor") >= 0)) || editor === null)) {
                return <any>this.addItem$java_lang_String$framework_builder_Editor(label, editor);
            } else if(((label != null && label instanceof <any>framework.lightning.TabItem) || label === null) && editor === undefined) {
                return <any>this.addItem$framework_lightning_TabItem(label);
            } else throw new Error('invalid overload');
        }
    }
    EditorTabs["__class"] = "framework.builder.EditorTabs";
    EditorTabs["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.builder.libraries {
    export class BasicComponentLibrary extends framework.builder.ComponentsLibrary {
        public constructor() {
            super("Basic");
            this.addComponents(new framework.builder.BasicComponent("h1", "H1", "Heading 1"), new framework.builder.BasicComponent("h2", "H2", "Heading 2"), new framework.builder.BasicComponent("h3", "H3", "Heading 3"), new framework.builder.BasicComponent("h4", "H4", "Heading 4"), new framework.builder.BasicComponent("h5", "H5", "Heading 5"), new framework.builder.BasicComponent("span", "SPAN", "Span"), new framework.builder.BasicComponent("p", "P", "Paragraph"), new framework.builder.BasicComponent("label", "LABEL", "Label"), new framework.builder.BasicComponent("a", "A", "Hyper Link"), new framework.builder.BasicComponent("img", "IMG", "Image"), new framework.builder.BasicComponent("ol", "OL", "Ordered List"), new framework.builder.BasicComponent("ul", "UL", "Un-Ordered List"), new framework.builder.BasicComponent("li", "LI", "List Item"), new framework.builder.BasicComponent("form", "FORM", "Form"), new framework.builder.BasicComponent("fieldset", "UL", "Fieldset"), new framework.builder.BasicComponent("input", "input", "Input"), new framework.builder.BasicComponent("select", "SELECT", "Select"), new framework.builder.BasicComponent("textarea", "TEXTAREA", "Text Area"), new framework.builder.BasicComponent("button", "BUTTON", "Button"));
        }
    }
    BasicComponentLibrary["__class"] = "framework.builder.libraries.BasicComponentLibrary";
    BasicComponentLibrary["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];


}
namespace framework.builder.libraries {
    export class LightningComponentLibrary extends framework.builder.ComponentsLibrary {
        public constructor() {
            super("Lightning");
            this.addComponents(new framework.builder.Component("lgt:btn", "BTN", "Button", new LightningComponentLibrary.LightningComponentLibrary$0(this, "lgt:btn")));
        }
    }
    LightningComponentLibrary["__class"] = "framework.builder.libraries.LightningComponentLibrary";
    LightningComponentLibrary["__interfaces"] = ["framework.configs.Designable","framework.Renderable"];



    export namespace LightningComponentLibrary {

        export class LightningComponentLibrary$0 extends framework.builder.AbstractComponentFactory {
            public __parent: any;
            /**
             * 
             * @return {framework.JSContainer}
             */
            public createInstance() : framework.JSContainer {
                return new framework.lightning.Button();
            }

            constructor(__parent: any, __arg0: any) {
                super(__arg0);
                this.__parent = __parent;
            }
        }
        LightningComponentLibrary$0["__interfaces"] = ["framework.builder.model.ComponentFactory"];


    }

}
namespace framework.builder {
    export class PropertiesEditor extends framework.lightning.FormLayout implements framework.EventListener, framework.builder.Editor {
        __framework_builder_PropertiesEditor_component : framework.configs.Designable;

        public constructor(name : string) {
            super(name, "div");
            this.__framework_builder_PropertiesEditor_component = null;
            this.setHorizontal(true).addClass("slds-form_compact");
        }

        public setComponent(designable : framework.configs.Designable) {
            this.__framework_builder_PropertiesEditor_component = designable;
        }

        public addProperty$java_lang_String$framework_JSInput(label : string, input : framework.JSInput) : PropertiesEditor {
            let width : framework.lightning.FormElement = new framework.lightning.FormElement("elem", "div");
            width.setLabel(label);
            input.addClass("slds-input");
            width.setInput(input);
            this.addFormElement(width);
            return this;
        }

        public addProperty(label? : any, input? : any) : any {
            if(((typeof label === 'string') || label === null) && ((input != null && input instanceof <any>framework.JSInput) || input === null)) {
                return <any>this.addProperty$java_lang_String$framework_JSInput(label, input);
            } else if(((label != null && label instanceof <any>framework.configs.Parameter) || label === null) && input === undefined) {
                return <any>this.addProperty$framework_configs_Parameter(label);
            } else throw new Error('invalid overload');
        }

        public addProperty$framework_configs_Parameter(parameter : framework.configs.Parameter) : PropertiesEditor {
            let element : framework.lightning.FormElement = new framework.lightning.FormElement("elem", "div");
            element.setLabel(parameter.label);
            if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(parameter.type, "String")) {
                let input : framework.JSInput = new framework.JSInput(parameter.name);
                input.addEventListener(this, "change");
                input.addClass("slds-input");
                element.setInput(input);
            } else if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(parameter.type, "Boolean")) {
                let cb : framework.lightning.CheckBox = new framework.lightning.CheckBox(parameter.name);
                cb.addEventListener(this, "change");
                element.setInput(cb);
            } else if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(parameter.type, "select")) {
                let select : framework.JSSelect = new framework.JSSelect(parameter.name);
                for(let index467=parameter.options.iterator();index467.hasNext();) {
                    let opt = index467.next();
                    {
                        let o : framework.JSOption = new framework.JSOption(opt.text, opt.value);
                        select.addOption(o);
                    }
                }
                select.addClass("slds-select");
                element.setInput(select);
                select.addEventListener(this, "change");
            } else if(/* equalsIgnoreCase */((o1, o2) => o1.toUpperCase() === (o2===null?o2:o2.toUpperCase()))(parameter.type, "textarea")) {
                let cb : framework.JSTextArea = new framework.JSTextArea(parameter.name);
                cb.addClass("slds-textarea");
                element.setInput(cb);
                cb.addEventListener(this, "change");
            }
            this.addFormElement(element);
            return this;
        }

        /**
         * 
         * @param {framework.JSContainer} source
         * @param {Event} evt
         */
        public performAction(source : framework.JSContainer, evt : Event) {
            let value : string = (<framework.InputField<any>><any>source).getValue().toString();
            alert(value);
            this.__framework_builder_PropertiesEditor_component.setParameter(source.getName(), value);
        }
    }
    PropertiesEditor["__class"] = "framework.builder.PropertiesEditor";
    PropertiesEditor["__interfaces"] = ["framework.builder.Editor","framework.EventListener","framework.configs.Designable","framework.Renderable"];


}
namespace framework.builder {
    export class AdvancedPropertiesEditorBody extends framework.builder.PropertiesEditor {
        public constructor() {
            super("advanced");
        }

        public setComponent(designable : framework.configs.Designable) {
            super.setComponent(designable);
            this.clear();
            for(let index468=this.__framework_builder_PropertiesEditor_component.getParameters().iterator();index468.hasNext();) {
                let p = index468.next();
                {
                    this.addProperty$framework_configs_Parameter(p);
                }
            }
        }
    }
    AdvancedPropertiesEditorBody["__class"] = "framework.builder.AdvancedPropertiesEditorBody";
    AdvancedPropertiesEditorBody["__interfaces"] = ["framework.builder.Editor","framework.EventListener","framework.configs.Designable","framework.Renderable"];


}
namespace framework.builder {
    export class BasicPropertiesEditorBody extends framework.builder.PropertiesEditor {
        public constructor(name : string) {
            super(name);
            this.addProperty$framework_configs_Parameter(new framework.configs.Parameter("name", "Name", "String"));
            this.addProperty$framework_configs_Parameter(new framework.configs.Parameter("class", "Style class", "String"));
            this.addProperty$framework_configs_Parameter(new framework.configs.Parameter("style", "Style", "String"));
            this.addProperty$framework_configs_Parameter(new framework.configs.Parameter("width", "Width", "String"));
            this.addProperty$framework_configs_Parameter(new framework.configs.Parameter("height", "Height", "String"));
        }
    }
    BasicPropertiesEditorBody["__class"] = "framework.builder.BasicPropertiesEditorBody";
    BasicPropertiesEditorBody["__interfaces"] = ["framework.builder.Editor","framework.EventListener","framework.configs.Designable","framework.Renderable"];


}
namespace framework.builder {
    export class EventsEditor extends framework.builder.PropertiesEditor {
        public constructor() {
            super("events");
            this.setStacked(true);
            let eventTypes : framework.configs.Parameter = new framework.configs.Parameter("eventType", "Event", "select");
            eventTypes.options.add(new framework.configs.Option("Click", "click"));
            eventTypes.options.add(new framework.configs.Option("Double click", "dblclick"));
            this.addProperty$framework_configs_Parameter(eventTypes);
            let script : framework.configs.Parameter = new framework.configs.Parameter("script", "Script", "textarea");
            this.addProperty$framework_configs_Parameter(script);
        }
    }
    EventsEditor["__class"] = "framework.builder.EventsEditor";
    EventsEditor["__interfaces"] = ["framework.builder.Editor","framework.EventListener","framework.configs.Designable","framework.Renderable"];


}


framework.lightning.Button.stateLabels_$LI$();

framework.lightning.Button.states_$LI$();

framework.JSContainer.DEFAULT_RENDERER_$LI$();

framework.interactions.InteractionsDecorator.droppableRenderer_$LI$();

framework.interactions.InteractionsDecorator.draggableRenderer_$LI$();

framework.core.BeanFactory.INSTANCE_$LI$();

framework.Main.main(null);
