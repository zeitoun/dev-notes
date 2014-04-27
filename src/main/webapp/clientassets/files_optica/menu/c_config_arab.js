// USE WORDWRAP AND MAXIMIZE THE WINDOW TO SEE THIS FILE
c_styles={};c_menus={}; // do not remove this line

// You can remove most comments from this file to reduce the size if you like.
/******************************************************
	(1) GLOBAL SETTINGS
*******************************************************/

c_hideTimeout=500; // 1000==1 second
c_subShowTimeout=300;
c_keepHighlighted=true;
c_findCURRENT=true; // find the item linking to the current page and apply it the CURRENT style class
c_findCURRENTTree=true;
c_overlapControlsInIE=true;
c_rightToLeft=true; // if the menu text should have "rtl" direction (e.g. Hebrew, Arabic)




/******************************************************
	(2) MENU STYLES (CSS CLASSES)
*******************************************************/

// You can define different style classes here and then assign them globally to the menu tree(s)
// in section 3 below or set them to any UL element from your menu tree(s) in the page source


var PATHNAME = document.location.pathname;
var APP_ROOT = (PATHNAME.split("/"))?"/"+( (PATHNAME.split("/"))[0].length>0? (PATHNAME.split("/"))[0]:(PATHNAME.split("/"))[1])+"/":"";

c_imagesPath=APP_ROOT+"clientassets/BMMB/assets/menu/"; // path to the directory containing the menu images


c_styles['MM']=[ // MainMenu (the shorter the class name the better)
[
// MENU BOX STYLE
0,		// BorderWidth
'',	// BorderStyle (CSS valid values except 'none')
'',	// BorderColor ('color')
0,		// Padding
'',	// Background ('color','transparent','[image_source]')
'',		// IEfilter (only transition filters work well - not static filters)
'opacity:0.9'		// Custom additional CSS for the menu box (valid CSS)
],[
// MENU ITEMS STYLE
0,		// BorderWidth
'',	// BorderStyle (CSS valid values except 'none')
'',	// OVER BorderStyle
'',	// BorderColor ('color')
'',	// OVER BorderColor
6,		// Padding
'transparent',	// Background ('color','transparent','[image_source]')
'#3a4051',	// OVER Background
'#3a4051',	// Color
'#ffffff',	// OVER Color
'16px',		// FontSize (values in CSS valid units - %,em,ex,px,pt)
'Arial',	// FontFamily
'bold',		// FontWeight (CSS valid values - 'bold','normal','bolder','lighter','100',...,'900')
'none',		// TextDecoration (CSS valid values - 'none','underline','overline','line-through')
'none',		// OVER TextDecoration
'right',		// TextAlign ('left','center','right','justify')
0,		// ItemsSeparatorSize
'',	// ItemsSeparatorStyle (border-style valid values)
'transparent',	// ItemsSeparatorColor ('color','transparent')
0,		// ItemsSeparatorSpacing
true,			// UseSubMenuImage (true,false)
'[h_arrow.gif]',	// SubMenuImageSource ('[image_source]')
'[h_arrow_over.gif]',	// OverSubMenuImageSource
11,			// SubMenuImageWidth
11,			// SubMenuImageHeight
'9',			// SubMenuImageVAlign ('pixels from item top','middle')
 
 '',		// solid VISITED BorderStyle
'',			// #e4e1e1 VISITED BorderColor
'',			// #e4e1e1 VISITED Background
'',			// #252455 VISITED Color
'',			// none  VISITED TextDecoration
'[h_arrow.gif]',	// VISITED SubMenuImageSource [assets/menu/h_arrow.gif]
'',		// CURRENT BorderStyle
'',		// CURRENT BorderColor
'transparent',		// CURRENT Background
'#ffae53',		// CURRENT Color
'none',			// CURRENT TextDecoration
'[h_arrow.gif]',	// CURRENT SubMenuImageSource
'',		// Custom additional CSS for the items (valid CSS)
'',		// OVER Custom additional CSS for the items (valid CSS)
'',		// CURRENT Custom additional CSS for the items (valid CSS)
''		// VISITED Custom additional CSS for the items (valid CSS)
]];


c_styles['SM']=[ // SubMenus
[
// MENU BOX STYLE
1,		// BorderWidth
'solid',	// BorderStyle (CSS valid values except 'none')
'#7c7c7c',	// BorderColor ('color')
0,		// Padding
'',	// Background ('color','transparent','[image_source]')
'',		// IEfilter (only transition filters work well - not static filters)
'opacity: 1'		// Custom additional CSS for the menu box (valid CSS)
],[
// MENU ITEMS STYLE
0,		// BorderWidth
'',	// BorderStyle (CSS valid values except 'none')
'',	// OVER BorderStyle
'',	// BorderColor ('color')
'',	// OVER BorderColor
5,		// Padding
'#3a4051',	// Background ('color','transparent','[image_source]')
'#3a4051',	// OVER Background
'#ffffff',	// Color
'#ffae53',	// OVER Color
'12px',		// FontSize (values in CSS valid units - %,em,ex,px,pt)
'Arial',	// FontFamily
'normal',	// FontWeight (CSS valid values - 'bold','normal','bolder','lighter','100',...,'900')
'none',		// TextDecoration (CSS valid values - 'none','underline','overline','line-through')
'none',		// OVER TextDecoration
'right',		// TextAlign ('left','center','right','justify')
1,		// ItemsSeparatorSize
'solid',	// ItemsSeparatorStyle (border-style valid values)
'#7c7c7c',	// ItemsSeparatorColor ('color','transparent')
0,		// ItemsSeparatorSpacing
true,			// UseSubMenuImage (true,false)
'[a_arrow.gif]',	// SubMenuImageSource ('[image_source]')
'[a_arrow_over.gif]',	// OverSubMenuImageSource
11,			// SubMenuImageWidth
11,			// SubMenuImageHeight
'7',			// SubMenuImageVAlign ('pixels from item top','middle')
'',			// solid  VISITED BorderStyle
'',			// #e4e1e1 VISITED BorderColor
'',			// #e4e1e1 VISITED Background
'',			// #252455 VISITED Color
'',			// noneVISITED TextDecoration
'[a_arrow.gif]',	// [assets/menu/a_arrow.gif] VISITED SubMenuImageSource
'',		// CURRENT BorderStyle
'',		// CURRENT BorderColor
'#3a4051',		// CURRENT Background
'#ffae53',		// CURRENT Color
'none',			// CURRENT TextDecoration
'[a_arrow.gif]',	// CURRENT SubMenuImageSource
'',		// Custom additional CSS for the items (valid CSS)
'',		// OVER Custom additional CSS for the items (valid CSS)
'',		// CURRENT Custom additional CSS for the items (valid CSS)
''		// VISITED Custom additional CSS for the items (valid CSS)
]];




/******************************************************
	(3) MENU TREE FEATURES
*******************************************************/

// Normally you would probably have just one menu tree (i.e. one main menu with sub menus).
// But you are actually not limited to just one and you can have as many menu trees as you like.
// Just copy/paste a config block below and configure it for another UL element if you like.


c_menus['Menu1']=[ // the UL element with id="Menu1"
[
// MAIN-MENU FEATURES
'horizontal',	// ItemsArrangement ('vertical','horizontal')
'relative',	// Position ('relative','absolute','fixed')
'0em',		// X Position (values in CSS valid units- px,em,ex)
'0em',		// Y Position (values in CSS valid units- px,em,ex)
true,		// RightToLeft display of the sub menus
false,		// BottomToTop display of the sub menus
0,		// X SubMenuOffset (pixels)
0,		// Y SubMenuOffset
'10em',		// Width (values in CSS valid units - px,em,ex) (matters for main menu with 'vertical' ItemsArrangement only)
'MM',		// CSS Class (one of the defined in section 2)
false		// Open sub-menus onclick (default is onmouseover)
],[
// SUB-MENUS FEATURES
5,		// X SubMenuOffset (pixels)
0,		// Y SubMenuOffset
'auto',		// Width ('auto',values in CSS valid units - px,em,ex)
'100',		// MinWidth ('pixels') (matters/useful if Width is set 'auto')
'300',		// MaxWidth ('pixels') (matters/useful if Width is set 'auto')
'SM',		// CSS Class (one of the defined in section 2)
false		// Open sub-menus onclick (default is onmouseover)
]];

///////*////////////////////////////////////////*///////////////////////////////

c_styles['MMLL']=[ // MainMenu (the shorter the class name the better)
[
// MENU BOX STYLE
0,		// BorderWidth
'',	// BorderStyle (CSS valid values except 'none')
'',	// BorderColor ('color')
0,			// Padding
'',	// Background ('color','transparent','[image_source]')
'',		// IEfilter (only transition filters work well - not static filters)
''		// Custom additional CSS for the menu box (valid CSS)
],[
// MENU ITEMS STYLE
0,		// BorderWidth
'',	// BorderStyle (CSS valid values except 'none')
'',	// OVER BorderStyle
'',	// BorderColor ('color')
'',	// OVER BorderColor
3,		// Padding
'#e6e6e6',	// Background ('color','transparent','[image_source]')
'#e6e6e6',	// OVER Background
'#004c93',	// Color
'#d53700',	// OVER Color
'13px',		// FontSize (values in CSS valid units - %,em,ex,px,pt)
'Arial',	// FontFamily
'bold',		// FontWeight (CSS valid values - 'bold','normal','bolder','lighter','100',...,'900')
'none',		// TextDecoration (CSS valid values - 'none','underline','overline','line-through')
'none',		// OVER TextDecoration
'left',		// TextAlign ('left','center','right','justify')
3,		// ItemsSeparatorSize
'',	// ItemsSeparatorStyle (border-style valid values)
'transparent',	// ItemsSeparatorColor ('color','transparent')
0,		// ItemsSeparatorSpacing
true,			// UseSubMenuImage (true,false)
'[h_arrow.gif]',		// SubMenuImageSource ('[image_source]')
'[h_arrow_over.gif]',	// OverSubMenuImageSource
7,				// SubMenuImageWidth
4,				// SubMenuImageHeight
'10',			// SubMenuImageVAlign ('pixels from item top','middle')
'',				// solid   VISITED BorderStyle
'',			// #0A76AC VISITED BorderColor
'',		// #0A76AC VISITED Background
'',			// #FFFFFF VISITED Color
'',			// none VISITED TextDecoration
'[h_arrow.gif]',	// [h_arrow.gif] VISITED SubMenuImageSource
'',		// CURRENT BorderStyle
'',		// CURRENT BorderColor
'#e6e6e6',		// CURRENT Background
'#d53700',		// CURRENT Color
'none',			// CURRENT TextDecoration
'[h_arrow.gif]',	// CURRENT SubMenuImageSource
'',		// Custom additional CSS for the items (valid CSS)
'',		// OVER Custom additional CSS for the items (valid CSS)
'',		// CURRENT Custom additional CSS for the items (valid CSS)
''		// VISITED Custom additional CSS for the items (valid CSS)
]];


c_styles['SMLL']=[ // SubMenus
[
// MENU BOX STYLE
1,		// BorderWidth
'solid',	// BorderStyle (CSS valid values except 'none')
'red',	// BorderColor ('color')
3,		// Padding
'#e4e1e1',	// Background ('color','transparent','[image_source]')
'',		// IEfilter (only transition filters work well - not static filters)
''		// Custom additional CSS for the menu box (valid CSS)
],[
// MENU ITEMS STYLE
1,		// BorderWidth
'solid',	// BorderStyle (CSS valid values except 'none')
'solid',	// OVER BorderStyle
'#e4e1e1',	// BorderColor ('color')
'blue',	// OVER BorderColor
3,		// Padding
'#e4e1e1',	// Background ('color','transparent','[image_source]')
'#CBCBEF',	// OVER Background
'#000000',	// Color
'#000000',	// OVER Color
'12px',		// FontSize (values in CSS valid units - %,em,ex,px,pt)
'Tahoma',	// FontFamily
'normal',	// FontWeight (CSS valid values - 'bold','normal','bolder','lighter','100',...,'900')
'none',		// TextDecoration (CSS valid values - 'none','underline','overline','line-through')
'none',		// OVER TextDecoration
'right',		// TextAlign ('left','center','right','justify')
0,			// ItemsSeparatorSize
'solid',	// ItemsSeparatorStyle (border-style valid values)
'#FF0000',	// ItemsSeparatorColor ('color','transparent')
2,			// ItemsSeparatorSpacing
true,			// UseSubMenuImage (true,false)
'[a_arrow.gif]',		// SubMenuImageSource ('[image_source]')
'[a_arrow_over.gif]',	// OverSubMenuImageSource
7,			// SubMenuImageWidth
7,			// SubMenuImageHeight
'7',			// SubMenuImageVAlign ('pixels from item top','middle')
'',			// solid VISITED BorderStyle
'',			// #e4e1e1 VISITED BorderColor
'',			// #e4e1e1 VISITED Background
'',			// #252455 VISITED Color
'',			// none VISITED TextDecoration
'[a_arrow.gif]',			// [a_arrow.gif] VISITED SubMenuImageSource
'solid',		// CURRENT BorderStyle
'#CBCBEF',		// CURRENT BorderColor
'#FFFBF0',		// CURRENT Background
'#252455',		// CURRENT Color
'none',			// CURRENT TextDecoration
'[a_arrow.gif]',	// CURRENT SubMenuImageSource
'',		// Custom additional CSS for the items (valid CSS)
'',		// OVER Custom additional CSS for the items (valid CSS)
'',		// CURRENT Custom additional CSS for the items (valid CSS)
''		// VISITED Custom additional CSS for the items (valid CSS)
]];




/******************************************************
	(3) MENU TREE FEATURES
*******************************************************/

// Normally you would probably have just one menu tree (i.e. one main menu with sub menus).
// But you are actually not limited to just one and you can have as many menu trees as you like.
// Just copy/paste a config block below and configure it for another UL element if you like.


c_menus['Menu1LL']=[ // the UL element with id="Menu1"
[
// MAIN-MENU FEATURES
'vertical',	// ItemsArrangement ('vertical','horizontal')
'relative',	// Position ('relative','absolute','fixed')
'0em',		// X Position (values in CSS valid units- px,em,ex)
'0em',		// Y Position (values in CSS valid units- px,em,ex)
true,		// RightToLeft display of the sub menus
false,		// BottomToTop display of the sub menus
0,			// X SubMenuOffset (pixels)
0,			// Y SubMenuOffset
'',		// Width (values in CSS valid units - px,em,ex) (matters for main menu with 'vertical' ItemsArrangement only)
'MMLL',		// CSS Class (one of the defined in section 2)
false		// Open sub-menus onclick (default is onmouseover)
],[
// SUB-MENUS FEATURES
5,		// X SubMenuOffset (pixels)
1,		// Y SubMenuOffset
'auto',		// Width ('auto',values in CSS valid units - px,em,ex)
'100',		// MinWidth ('pixels') (matters/useful if Width is set 'auto')
'300',		// MaxWidth ('pixels') (matters/useful if Width is set 'auto')
'SMLL',		// CSS Class (one of the defined in section 2)
false		// Open sub-menus onclick (default is onmouseover)
]]; 