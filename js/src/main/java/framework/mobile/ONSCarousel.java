package framework.mobile;


import framework.EventListener;
import framework.JSContainer;
import jsweet.lang.JSON;
import jsweet.lang.Object;

public class ONSCarousel extends JSContainer {

	private String direction;
	private boolean fullscreen;
	private boolean overscrollable;
	private boolean centered;
	private String itemWidth;
	private String itemHeight;
	private boolean autoScroll;
	private double autoScrollRatio;
	private boolean swipeable;
	private boolean disabled;
	private Integer initialIndex;
	private boolean autoRefresh;
	private String animation;
	private Object animationOptions;
	private EventListener postchange;
	private EventListener refresh;
	private EventListener overscroll;

	public ONSCarousel(String name) {
		super(name, "ons-carousel");
	}
	
	
	public void setActiveIndex(int index, Object options){
		//Specify the index of the <ons-carousel-item> to show.
	}
	public void next(Object options)	{
		//Show next <ons-carousel-item>.
	}
	public void prev(Object options)	{
		//Show previous <ons-carousel-item>.
	}
	public void refresh()	{
		//Update the layout of the carousel. Used when adding <ons-carousel-items> dynamically or to automatically adjust the size.
	}
	public void first(){
		//Show first <ons-carousel-item>.
	}
	public void last(){
		//Show last ons-carousel item.
	}


	protected void setBoolean(String attr, boolean b){
		if(b){
			setAttribute(attr, "true");
		}else{
			setAttribute(attr, (String)null);
		}
	}
	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
		setAttribute("direction", direction);
	}


	public boolean isFullscreen() {
		return fullscreen;
	}


	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
		setBoolean("fullscreen", fullscreen);
		
	}


	public boolean isOverscrollable() {
		return overscrollable;
	}


	public void setOverscrollable(boolean overscrollable) {
		this.overscrollable = overscrollable;
		setBoolean("overscrollable", overscrollable);
	}


	public boolean isCentered() {
		return centered;
	}


	public void setCentered(boolean centered) {
		this.centered = centered;
		setBoolean("centered", centered);
	}


	public String getItemWidth() {
		return itemWidth;
	}


	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
		setAttribute("item-width", itemWidth);
	}


	public String getItemHeight() {
		return itemHeight;
	}


	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
		setAttribute("item-height", itemHeight);
	}


	public boolean isAutoScroll() {
		return autoScroll;
	}


	public void setAutoScroll(boolean autoScroll) {
		this.autoScroll = autoScroll;
		setBoolean("auto-scroll", autoScroll);
	}


	public double getAutoScrollRatio() {
		return autoScrollRatio;
	}


	public void setAutoScrollRatio(double autoScrollRatio) {
		this.autoScrollRatio = autoScrollRatio;
		setAttribute("auto-scroll-ratio", autoScrollRatio + "");
	}


	public boolean isSwipeable() {
		return swipeable;
	}


	public void setSwipeable(boolean swipeable) {
		this.swipeable = swipeable;
		setBoolean("swipable", swipeable);
	}


	public boolean isDisabled() {
		return disabled;
	}


	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
		setBoolean("disabled", disabled);
	}


	public Integer getInitialIndex() {
		return initialIndex;
	}


	public void setInitialIndex(Integer initialIndex) {
		this.initialIndex = initialIndex;
		setAttribute("initial-index", initialIndex.toString());
	}


	public boolean isAutoRefresh() {
		return autoRefresh;
	}


	public void setAutoRefresh(boolean autoRefresh) {
		this.autoRefresh = autoRefresh;
		setBoolean("auto-refresh", autoRefresh);
	}


	public String getAnimation() {
		return animation;
	}


	public void setAnimation(String animation) {
		this.animation = animation;
		setAttribute("animation", animation);
	}


	public Object getAnimationOptions() {
		return animationOptions;
	}


	public void setAnimationOptions(Object animationOptions) {
		this.animationOptions = animationOptions;
		if(animationOptions != null)
			setAttribute("animation-options", JSON.stringify(animationOptions));
		else
			setAttribute("animation-options", (String)null);
	}


	public EventListener getPostchange() {
		return postchange;
	}


	public void setPostchange(EventListener postchange) {
		this.postchange = postchange;
		addEventListener(postchange, "postchange");
	}


	public EventListener getRefresh() {
		return refresh;
	}


	public void setRefresh(EventListener refresh) {
	
		this.refresh = refresh;
		addEventListener(refresh, "refresh");
	}


	public EventListener getOverscroll() {
		return overscroll;
	}


	public void setOverscroll(EventListener overscroll) {
		this.overscroll = overscroll;
		addEventListener(overscroll, "overscroll");
	}
	
	

}
