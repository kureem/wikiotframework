package framework.mobile;

import framework.EventListener;

public class ONSPage extends ONSModifiable {

	private EventListener onInfiniteScroll_;

	private EventListener init;

	private EventListener show;

	private EventListener hide;

	private EventListener destroy;

	public ONSPage(String name) {
		super(name, "ons-page");
	}

	
	public ONSPage setOnInfiniteScroll(EventListener EventListener) {

		addEventListener(EventListener, "on-infinite-scroll");
		this.onInfiniteScroll_ = EventListener;
		return this;
	}

	public EventListener getOnInfiniteScroll() {
		return onInfiniteScroll_;
	}

	public EventListener getInit() {
		return init;
	}

	public void setInit(EventListener init) {
		addEventListener(init, "init");
		this.init = init;
	}

	public EventListener getShow() {
		return show;
	}

	public void setShow(EventListener show) {
		addEventListener(show, "show");
		this.show = show;
	}

	public EventListener getHide() {
		return hide;
	}

	public void setHide(EventListener hide) {
		addEventListener(hide, "hide");
		this.hide = hide;
	}

	public EventListener getDestroy() {
		return destroy;
	}

	public void setDestroy(EventListener destroy) {
		addEventListener(destroy,"destroy" );
		this.destroy = destroy;
	}

}
