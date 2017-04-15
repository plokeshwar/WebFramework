var popupStatus = 0;

//loading popup with jQuery magic!
function loadPopup1(pcontact, bgcontact){
	//loads popup only if it is disabled
	var popupdiv = document.getElementById(pcontact);
	var pagebgdiv = document.getElementById(bgcontact);
	if(popupStatus==0){
		jQuery("#"+pagebgdiv.id).css({
			"opacity": "0.4"
		});
		
		jQuery("#"+pagebgdiv.id).fadeIn("slow");
		jQuery("#"+popupdiv.id).fadeIn("slow");
		popupStatus = 1;
	}
}

//disabling popup with jQuery magic!
function disablePopup1(pcontact, bgcontact){
	//disables popup only if it is enabled
	var popupdiv = document.getElementById(pcontact);
	var pagebgdiv = document.getElementById(bgcontact);
	if(popupStatus==1){
		jQuery("#"+pagebgdiv.id).fadeOut("slow");
		jQuery("#"+popupdiv.id).fadeOut("slow");
		popupStatus = 0;
		
	}
	
}

//centering popup
function centerPopup1(pcontact, bgcontact){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	//var windowHeight = window.innerHeight;
	
	var popupdiv = document.getElementById(pcontact);
	var pagebgdiv = document.getElementById(bgcontact);
	
	var popupHeight = jQuery("#"+popupdiv.id).height();
	var popupWidth = jQuery("#"+popupdiv.id).width();

	if(windowWidth/2 >= (windowWidth/2-popupWidth/2))
	{
	//centering
		jQuery("#"+popupdiv.id).css({
			
			"position": "absolute",
			//"top": windowHeight/2-popupHeight/2,
			"left": windowWidth/2-popupWidth/2
		});
	}
	else
	{
		jQuery("#"+popupdiv.id).css({
			
			"position": "absolute",
			//"top": windowHeight/2-popupHeight/2,
			"left": windowWidth/2-popupWidth/2
		});
	}
	//only need force for IE6
	
	jQuery("#"+pagebgdiv.id).css({
		"height": windowHeight
		
	});
	document.getElementById (pcontact).style.maxHeight = "430px";
	
}

function openPopup(maindiv, bgdiv)
{
		var popupdiv = document.getElementById(maindiv);
		var pagebgdiv = document.getElementById(bgdiv);
		
		
		//load popup
		loadPopup1(popupdiv.id,pagebgdiv.id);
}
function maximize(pcontact, bgcontact){
	/*if($('#EmpDelimg').is(":visible")) // Checks for display:[none|block], ignores visible:[true|false
	{*/
		var windowWidth = document.documentElement.clientWidth;
		var windowHeight = document.documentElement.clientHeight;
		
		var popupdiv = document.getElementById(pcontact);
		document.getElementById (pcontact).style.maxHeight = "1020px";
		
		 window.div_height = popupdiv.style.height;
		 window.div_width = popupdiv.style.width;
		 window.divtop = popupdiv.style.top;
		 window.divleft = popupdiv.style.left;

		 var hideminbutton = document.getElementsByClassName('dialog-maximize');
		 for(var i=0; i<hideminbutton.length; i++) { 
			 hideminbutton[i].style.display='none';
		 }
		 
		 var hideminbutton = document.getElementsByClassName('dialog-maximize-return');
		 for(var i=0; i<hideminbutton.length; i++) { 
			 hideminbutton[i].style.display='block';
		 }
		 
		 var myWidth = 0, myHeight = 0;
		 if( typeof( window.innerWidth ) == 'number' ) {
		 //Non-IE
		 myWidth = window.innerWidth;
		 myHeight = window.innerHeight;
		 } else if( document.documentElement &&
		 ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
		 //IE 6+ in 'standards compliant mode'
		 myWidth = document.documentElement.clientWidth;
		 myHeight = document.documentElement.clientHeight;
		 } else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
		 //IE 4 compatible
		 myWidth = document.body.clientWidth;
		 myHeight = document.body.clientHeight;
		 }
		 myWidth = myWidth -25;
		 myHeight = myHeight -20;
		/* var popup_element = document.getElementById('popup-container');*/
		 popupdiv.style.position ="absolute";
		 popupdiv.style.left ="10px";
		 popupdiv.style.maxHeight = myHeight +"px";
		 popupdiv.style.width = myWidth +"px";
		 popupdiv.style.top = "5px";
		 document.getElementById (pcontact).style.maxHeight = "1080px";
	/*}
		else{alert ("Sorry, you need to have more Employment Sections to maximize");}*/
	}

function maximize_restore(pcontact, bgcontact){

	var popupdiv = document.getElementById(pcontact);
	popupdiv.style.position ="absolute";
	popupdiv.style.left = window.divleft;
	popupdiv.style.top = window.divtop;
	popupdiv.style.height = window.div_height;
	popupdiv.style.width = window.div_width;
	 
	var hideminbutton = document.getElementsByClassName('dialog-maximize');
	 for(var i=0; i<hideminbutton.length; i++) { 
		 hideminbutton[i].style.display='block';
	 }
	 
	 var hideminbutton = document.getElementsByClassName('dialog-maximize-return');
	 for(var i=0; i<hideminbutton.length; i++) { 
		 hideminbutton[i].style.display='none';
	 }
	 document.getElementById (pcontact).style.maxHeight = "407px";
	 centerPopup1(pcontact, bgcontact);
	}
