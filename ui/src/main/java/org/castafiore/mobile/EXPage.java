package org.castafiore.mobile;

import org.castafiore.ui.Event;

public class EXPage extends EXModifiable {

	private Event onInfiniteScroll_;

	private Event init;

	private Event show;

	private Event hide;

	private Event destroy;

	public EXPage(String name) {
		super(name, "ons-page");
	}

	
	public EXPage setOnInfiniteScroll(Event event) {

		addEvent(event, "on-infinite-scroll");
		this.onInfiniteScroll_ = event;
		return this;
	}

	public Event getOnInfiniteScroll() {
		return onInfiniteScroll_;
	}

	public Event getInit() {
		return init;
	}

	public void setInit(Event init) {
		addEvent(init, "init");
		this.init = init;
	}

	public Event getShow() {
		return show;
	}

	public void setShow(Event show) {
		addEvent(show, "show");
		this.show = show;
	}

	public Event getHide() {
		return hide;
	}

	public void setHide(Event hide) {
		addEvent(hide, "hide");
		this.hide = hide;
	}

	public Event getDestroy() {
		return destroy;
	}

	public void setDestroy(Event destroy) {
		addEvent(destroy,"destroy" );
		this.destroy = destroy;
	}

}
