package com.dev.admin.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hdc.sysdev.utils.StringUtil;

/**
 * Servlet implementation class Fuel
 */
public class Fuel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private String valueBean;

	private Long formLastAccess;

	private boolean includeLeftMenu = false;
	private boolean includeRightMenu = false;
	private boolean includeRightNewsFeed = false;
	private boolean includeHeader = true;
	private boolean includeFooter = true;
	private boolean includeHorizontalUserInfo = true;

	//these parameters are for Header
	private String title;
	private String currentServletName;
	private boolean includeMenu = true;
	private boolean includeLanguage = false;

	private boolean includeJsAlertTranslation = false;

	private String scriptIncludes  = new String();
	private String scriptFunctions = new String();
	private String jsInstance = new String();

	private StringBuffer pageConstructor = new StringBuffer();
	private StringBuffer leftMenuConstructor = new StringBuffer();
	private StringBuffer rightMenuConstructor = new StringBuffer();

	String  onLoadFunctions   = "";
	String  onUnloadFunctions = "";


	/**
	 * Default constructor. 
	 */
	public Fuel() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache,post-check=0,pre-check=0,no-store,private");
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server
		String htmlDirection = "ltr";
		
		String rechargeDate = StringUtil.nullOrEmptyToString(request.getParameter("rechargeDate"),"");	
		Double amount = Double.parseDouble(request.getParameter("amount"));
		Double liters = Double.parseInt(request.getParameter("liters"));
		Double miles = Double.parseInt(request.getParameter("miles"));
		Double kms = Double.parseInt(request.getParameter("kms"));
		Double price = Double.parseDouble(request.getParameter("price"));
		String fuelType = Double.parseDouble(request.getParameter("fuelType"));
		String isPaid = Double.parseDouble(request.getParameter("isPaid"));
		String stationName = StringUtil.nullOrEmptyToString(request.getParameter("stationName"), "");
		String carModel = StringUtil.nullOrEmptyToString(request.getParameter("carModel"),"");
		
		
			
			
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML>");
		//end html5 tag
		out.println("<html "+htmlDirection+" " + "xmlns=\"http://www.w3.org/1999/xhtml>");
		out.println("<head>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1; no-cache; \" />");
		//		out.println("		<link rel=\"icon\" href=\"clientassets/files_optica/assets/common/favicon.ico\" />");
		out.println("		<base href=\"#\" target=\"_self\"> ");
		out.println(" 		<!-- MYLOGS 0.0.0.1-->");
		out.println("       <title> MYLOGS </title>");		
		out.println(		new String(includeScripts()));
		out.println(		new String(constructScriptFunctions()));
		out.println("</head>");

		out.println("<body style=\"overflow: auto;\" onload=\""+ includeOnLoadFunctions() +"\" onunload=\""+ includeOnUnLoadFunctions() +"\">");

		out.println("	<form name=\"reqForm\" method=\"post\" id=\"reqForm\" >");

		out.println("	<div id=\"header-wrap\"> ");
		out.println("	<table width=\"100%\">");
		out.println("		<tr>");
		out.println("			<td width=\"100%\">");
		if(isIncludeHeader())
			out.println(        	includeHeader(request));
		out.println("			</td>");
		out.println("		</tr>");
		out.println("	</table>");
		out.println("	</div> ");

		out.println("	<div id=\"container\"> ");
		out.println("	<table border=1 class=\"wrapperAllTable\">");


		//Content
		out.println("		<tr height=\"500px\" valign=\"top\" >");
		out.println("			<td width=\"100%\">");
		out.println("				<table border=0 class=\"bodyTable\">");
		out.println("					<tr valign=\"top\">");
		out.println("						<td width=\"75%\" id=\"mainBodyTD\">");
		out.println(							new String(this.constructPage(request)));
		out.println("						</td>");
		out.println("					</tr>");
		out.println("				</table>");
		out.println("			</td>");
		out.println("   	</tr>");

		//Spacing Between Content and Footer
		out.println("		<tr height=\"2%\">");
		out.println("			<td><br/><br/></td>");
		out.println("		</tr>");
		out.println("	</table>");

		out.println("	</div>");


		out.println("	<div id=\"footer\"> ");
		out.println("	<table style=\"font-size: 12px; text-align: center; width:100%;\">");
		out.println("		<tr>");
		out.println("			<td width=\"100%\">");
		if(isIncludeFooter())
			out.println(        	includeFooter());;
			out.println("			</td>");
			out.println("		</tr>");
			out.println("	</table>");
			out.println("	</div> ");


			out.println("	</form>");
			out.println("	<script>");
			out.println(		includeJSInstance()	);
			out.println("	</script>");
			out.println("</body>");
			out.println("</html>");

			out.flush();
			out.close();
	}

	/**
	 * Gets the scripts included in the subclasses along with the
	 * common scriptat are common to all pages and that are defined here
	 * 
	 * @return
	 */
	protected StringBuffer includeScripts(){

		StringBuffer scripts = new StringBuffer();

		scripts.append("<link href=\"clientassets/files_optica/css/styles.css\" rel=\"stylesheet\" type=\"text/css\" />");
		scripts.append("<script language=\"Javascript\" src=\"common/XperteamLibrary.js\" type=\"text/javascript\"></script>");
		scripts.append("<script language=\"Javascript\" src=\"common/util/PopupWindow.js\" type=\"text/javascript\"></script>");
		scripts.append("<script language=\"Javascript\" src=\"common/Common.js\" type=\"text/javascript\"></script>");


		return scripts.append(new String(getScriptIncludes()));
	}

	/**
	 * Gets the scripts included such as formIns - dateIns - numberFormat... 
	 * 
	 * @return
	 */
	private StringBuffer includeJSInstance(){

		StringBuffer scripts = new StringBuffer();
		return scripts.append(new String(this.getJsInstance()));
	}

	/**
	 * Gets the script functions included in the subclasses along with
	 * the common script functions that are common to all pages and that are defined
	 * here
	 * 
	 * @return
	 */
	private String constructScriptFunctions(){
		return getScriptFunctions();
	}

	/**
	 * Gets the page constructor from the different subclasses and include them
	 * in the doPost
	 * 
	 * @return
	 */
	private StringBuffer constructPage(HttpServletRequest request){
		StringBuffer pageConstructor = new StringBuffer();


		pageConstructor.append("<div>");
		pageConstructor.append("	Date");
		pageConstructor.append("	<input name=\"systemDate\" id=\"systemDate\" type=\"hidden\" onpaste=\"return false\" value=\""+new java.util.Date()+"\" /> ");
		pageConstructor.append("	<input class=\"dateStyle\" name=\"rechargeDate\" readonly size=\"12\" required=\"true\" type=\"text\" id=\"rechargeDate\" maxlength=\"20\" value=\"\" onfocus=\"this.blur()\"> ");
		pageConstructor.append("		<a href=\"javascript:void(0)\" onclick=\"if(self.gfPop)gfPop.fEndPop(document.reqForm.systemDate,document.reqForm.rechargeDate);return false;\">");
		pageConstructor.append("			<img class=\"PopcalTrigger\" align=\"absmiddle\" src=\"common/calendar/DateRange/calbtn.gif\" width=\"34\" height=\"22\" border=\"0\" alt=\"\">");
		pageConstructor.append("		</a>");
		pageConstructor.append("</div>");
		pageConstructor.append("<div>");
		pageConstructor.append("	Amount");
		pageConstructor.append("	<input type=\"text\" name=\"amount\" id=\"amount\" value=\"\">");
		pageConstructor.append("</div>");
		pageConstructor.append("<div>");
		pageConstructor.append("	Liters");
		pageConstructor.append("	<input type=\"text\" name=\"liters\" id=\"liters\" value=\"\">");
		pageConstructor.append("</div>");
		pageConstructor.append("<div>");
		pageConstructor.append("	runed Miles");
		pageConstructor.append("	<input type=\"text\" name=\"miles\" id=\"miles\" value=\"\">");
		pageConstructor.append("</div>");
		pageConstructor.append("<div>");
		pageConstructor.append("	runed KMs");
		pageConstructor.append("	<input type=\"text\" name=\"kms\" id=\"kms\" value=\"\">");
		pageConstructor.append("</div>");
		pageConstructor.append("<div>");
		pageConstructor.append("	actualPrice");
		pageConstructor.append("	<input type=\"text\" name=\"price\" id=\"price\" value=\"\">");
		pageConstructor.append("</div>");
		pageConstructor.append("<div>");
		pageConstructor.append("	Fuel Type");
		pageConstructor.append("	<select name=\"fuelType\" id=\"fuelType\" onkeypress=\"this.onchange()\" onChange=\"setDropDownData('fuelTypeID','fuelTypeName')\" required=\"true\" tabindex=\"4\" >");
		pageConstructor.append("		<option title=\"0\" value=\"0\">92 Oct</option>");
		pageConstructor.append("		<option title=\"0\" value=\"1\">95 Oct</option>");
		pageConstructor.append("		<option title=\"0\" value=\"2\">98 Oct</option>");
		pageConstructor.append("	</select>");
		pageConstructor.append("</div>");
		pageConstructor.append("<div>");
		pageConstructor.append("	Fuel Station Name");
		pageConstructor.append("	<input type=\"text\" name=\"stationName\" id=\"stationName\" value=\"\">");
		pageConstructor.append("</div>");
		pageConstructor.append("<div>");
		pageConstructor.append("	isPaid");
		pageConstructor.append("	<input type=\"text\" name=\"isPaid\" id=\"isPaid\" value=\"\">");
		pageConstructor.append("</div>");
		pageConstructor.append("<div>");
		pageConstructor.append("	Car Model");
		pageConstructor.append("	<select name=\"carModel\" id=\"carModel\" onkeypress=\"this.onchange()\" onChange=\"setDropDownData('carModelID','carModelName')\" required=\"true\" tabindex=\"4\" >");
		pageConstructor.append("		<option title=\"0\" value=\"0\">RAV4</option>");
		pageConstructor.append("		<option title=\"0\" value=\"1\">BMW</option>");
		pageConstructor.append("	</select>");
		pageConstructor.append("</div>");
		pageConstructor.append("<div>");
		pageConstructor.append("	<a href=\"#\" class=\"btn_large btn_blue btn_awesome\" rel=\"nofollow\" ");
		pageConstructor.append("			 onClick=\"this.disabled='disabled';createLoadingImg();submitForm('document.reqForm','"+this.getServletName()+"?','submit');\" >");
		pageConstructor.append("		Submit");
		pageConstructor.append("	</a>");
		pageConstructor.append("</div>");

		pageConstructor.append("<iframe width=132 height=142 name=\"gToday:contrast:agenda.js\" id=\"gToday:contrast:agenda.js\"");
		pageConstructor.append("	src=\"common/calendar/DateRange/ipopeng.htm\" scrolling=\"no\" frameborder=\"0\"");
		pageConstructor.append("	style=\"visibility: visible; z-index: 999; position: absolute; top: -500px;\">");
		pageConstructor.append("</iframe>");

		return pageConstructor;
	}
	public String getValueBean() {
		return valueBean;
	}

	/**
	 * Returns the html code of the common header for all pages
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return String
	 */
	private String includeHeader(HttpServletRequest request){

		HttpSession session = request.getSession(true);

		String sessionBean = (getValueBean() == null ? "": getValueBean() );
		String theSessionBean = (session.getAttribute("sessionBean") == null ? "" :(String)session.getAttribute("sessionBean"));

		session.setAttribute("sessionBean", sessionBean);

		if(! sessionBean.equals(theSessionBean)){
			session.removeAttribute(""+theSessionBean+"");
		}


		StringBuffer headerConstructor  = new StringBuffer();
		headerConstructor.append("	<table border=0 class=\"headerTable\">");
		headerConstructor.append("		<tbody>");
		headerConstructor.append("			<tr>");
		headerConstructor.append("				<td  width=\"100%\">");
		//		BEGIN Header
		headerConstructor.append("					<table class=\"headerMainTable\">");
		headerConstructor.append("  					<tr>");
		headerConstructor.append("    						 <td style=\"font-size: 35px; color: #FFFFFF;\" align=\"center\" width=\"20%\"><b>OPTICA</b></td>");	
		headerConstructor.append("  					</tr>");
		headerConstructor.append("					</table>");
		headerConstructor.append("				</td>");
		headerConstructor.append("			</tr>");
		headerConstructor.append("			<tr>");
		headerConstructor.append("				 <td>");
		headerConstructor.append("		</tbody>");
		headerConstructor.append("	</table>");


		return (new String(headerConstructor));

	}



	/**
	 * Returns Footer Html Code as String
	 * 
	 * @param request
	 * @param response
	 */
	private String includeFooter()
	{
		StringBuffer footerConstructor = new StringBuffer();
		try {
			footerConstructor.append("						<table border=\"0\" class=\"FooterTable\">");
			footerConstructor.append("							<tbody>");
			footerConstructor.append("								<tr>");
			footerConstructor.append("									<td align=\"center\">");
			footerConstructor.append("											<p>Copyright ©2013 <b>Pro-Soft</b>. All rights reserved.</p>");
			footerConstructor.append("									</td>");
			footerConstructor.append("								</tr>");
			footerConstructor.append("							</tbody>");
			footerConstructor.append("						</table>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new String(footerConstructor));
	}

	/**
	 * Includes onLoad functions
	 * 
	 * @return
	 */
	private StringBuffer includeOnLoadFunctions(){
		StringBuffer functions = new StringBuffer();
		return functions.append(getOnLoadFunctions().toString());
	}

	/**
	 * Includes onUnLoad functions
	 * 
	 * @return 
	 */
	private StringBuffer includeOnUnLoadFunctions(){
		StringBuffer functions = new StringBuffer();
		return functions.append(getOnUnloadFunctions().toString());
	}

	/**
	 * @return the pageConstructor
	 */
	public StringBuffer getPageConstructor(){
		return pageConstructor;
	}

	/**
	 * @param pageConstructor the pageConstructor to set 
	 */
	public void setPageConstructor(StringBuffer pageConstructor){
		this.pageConstructor = pageConstructor;
	}

	/**
	 * @return the scriptFunctions
	 */
	public String getScriptFunctions(){
		return scriptFunctions;
	}

	/**
	 * @param scriptFunctions the scriptFunctions to set 
	 */
	public void setScriptFunctions(String scriptFunctions){
		this.scriptFunctions = scriptFunctions;
	}

	/**
	 * @return the scriptIncludes 
	 */
	public String getScriptIncludes(){
		return scriptIncludes;
	}

	/**
	 * @param scriptIncludes the scriptIncludes to set 
	 */
	public void setScriptIncludes(String scriptIncludes){
		this.scriptIncludes = scriptIncludes;
	}
	/**
	 * @return the onLoadFunctions
	 */
	public String getOnLoadFunctions() {
		return onLoadFunctions;
	}

	/**
	 * @param onLoadFunctions the onLoadFunctions to set
	 */
	public void setOnLoadFunctions(String onLoadFunctions) {
		this.onLoadFunctions = onLoadFunctions;
	}

	/**
	 * @return the onUnloadFunctions
	 */
	public String getOnUnloadFunctions() {
		return onUnloadFunctions;
	}

	/**
	 * @param onUnloadFunctions the onUnloadFunctions to set
	 */
	public void setOnUnloadFunctions(String onUnloadFunctions) {
		this.onUnloadFunctions = onUnloadFunctions;
	}

	/**
	 * @return the jsInstance
	 */
	public String getJsInstance() {
		return jsInstance;
	}

	/**
	 * @param jsInstance the jsInstance to set
	 */
	public void setJsInstance(String jsInstance) {
		this.jsInstance = jsInstance;
	}
	/**
	 * @return the formLastAccess
	 */
	public Long getFormLastAccess() {
		return formLastAccess;
	}

	/**
	 * @param formLastAccess the formLastAccess to set
	 */
	public void setFormLastAccess(Long formLastAccess) {
		this.formLastAccess = formLastAccess;
	}

	/**
	 * @return the includeLeftMenu
	 */
	public boolean isIncludeLeftMenu() {
		return includeLeftMenu;
	}

	/**
	 * @return the includeRightMenu
	 */
	public boolean isIncludeRightMenu() {
		return includeRightMenu;
	}
	/**
	 * 
	 * @return the includeRightNewsFeed
	 */
	public boolean isIncludeRightNewsFeed(){
		return includeRightNewsFeed;
	}

	/**
	 * @param includeLeftMenu the includeLeftMenu to set
	 */
	public void setIncludeLeftMenu(boolean includeLeftMenu) {
		this.includeLeftMenu = includeLeftMenu;
	}

	/**
	 * @param includeRightMenu the includeRightMenu to set
	 */
	public void setIncludeRightMenu(boolean includeRightMenu) {
		this.includeRightMenu = includeRightMenu;
	}

	/**
	 * 
	 * @param includeRightNewsFeed the includeRightNewsFeed to set
	 */
	public void setIncludeRightNewsFeed(boolean includeRightNewsFeed){
		this.includeRightNewsFeed = includeRightNewsFeed;
	}

	/**
	 * @return the includeHeader
	 */
	public boolean isIncludeHeader() {
		return includeHeader;
	}

	/**
	 * @param includeHeader the includeHeader to set
	 */
	public void setIncludeHeader(boolean includeHeader) {
		this.includeHeader = includeHeader;
	}

	/**
	 * @return the includeFooter
	 */
	public boolean isIncludeFooter() {
		return includeFooter;
	}

	/**
	 * @param includeFooter the includeFooter to set
	 */
	public void setIncludeFooter(boolean includeFooter) {
		this.includeFooter = includeFooter;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the currentServletName
	 */
	public String getCurrentServletName() {
		return currentServletName;
	}

	/**
	 * @param currentServletName the currentServletName to set
	 */
	public void setCurrentServletName(String currentServletName) {
		this.currentServletName = currentServletName;
	}


	/**
	 * @return the includeMenu
	 */
	public boolean isIncludeMenu() {
		return includeMenu;
	}

	/**
	 * @param includeMenu the includeMenu to set
	 */
	public void setIncludeMenu(boolean includeMenu) {
		this.includeMenu = includeMenu;
	}

	/**
	 * @return the includeJsAlertTranslation
	 */
	public boolean isIncludeJsAlertTranslation() {
		return includeJsAlertTranslation;
	}

	/**
	 * @param includeJsAlertTranslation the includeJsAlertTranslation to set
	 */
	public void setIncludeJsAlertTranslation(boolean includeJsAlertTranslation) {
		this.includeJsAlertTranslation = includeJsAlertTranslation;
	}

	/**
	 * @return the includeLanguage
	 */
	public boolean isIncludeLanguage() {
		return includeLanguage;
	}

	/**
	 * @param includeLanguage the includeLanguage to set
	 */
	public void setIncludeLanguage(boolean includeLanguage) {
		this.includeLanguage = includeLanguage;
	}


	public StringBuffer getLeftMenuConstructor() {
		return leftMenuConstructor;
	}

	public void setLeftMenuConstructor(StringBuffer leftMenuConstructor) {
		this.leftMenuConstructor = leftMenuConstructor;
	}

	public StringBuffer getRightMenuConstructor() {
		return rightMenuConstructor;
	}

	public void setRightMenuConstructor(StringBuffer rightMenuConstructor) {
		this.rightMenuConstructor = rightMenuConstructor;
	}


	public boolean isIncludeHorizontalUserInfo() {
		return includeHorizontalUserInfo;
	}

	public void setIncludeHorizontalUserInfo(boolean includeHorizontalUserInfo) {
		this.includeHorizontalUserInfo = includeHorizontalUserInfo;
	}

	public String getName(String name){

		if(name == null) return "";

		return name.toUpperCase();
	}

}
