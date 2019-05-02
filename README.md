# Project5Final
Documentation

Methods
GetHamDist():
  simply claculates the Hamming distance between two stations
  Parameters:
    STID1 - first station used in comparison
    STID2 - second station used in comparison
  Returns:
    int with the value of the hamming distance of STID1 and STID2
    
SetupSignaturePanel():
  sets up the singature panel used for drawing
  Parameters:
    none
  Returns:
    none
    
SetupJTextFields():
  sets up the TextFields used for displaying information
  Parameters:
    none
  Returns:
    none
    
SetupJTextAreas():
  sets up the TextAreas used for entering information
  Parameters:
    none
  Returns:
    none
    
SetupJLabels():
  sets up the labels used for displaying information
  Parameters:
    none
  Returns:
    none
    
SetupJButtons():
  sets up the Buttons used for interacting with the program
  Parameters:
    none
  Returns:
    none
    
SetupJDropdown():
  sets up the dropdownbox used for displaying information
  Parameters:
    none
  Returns:
    none
    
SetupSlider():
  sets up the slider used for selecting hamming distance
  Parameters:
    none
  Returns:
    none
    
Project5()
  constructor, used for initialzing/adding Jelements and setting up the JFrame
 
main()
  main method, used for starting program
  
Approach:
Firstly, I tried to setup my program in a presentable fashion. Im still not an expert with gui and graphics so organizing things nicely is important for me.

I started picturing what elements I would use for each piece of the sample program and started thinking about how I would lay them out in my head. I went through multiple steps declaring and setting up my program but the hardest part was the Jbutton method as I declared the actionlisteners in that program too which made things a little hard to follow after putting down my computer and picking it up later. I had a little help getting things to work from my friend whos a semester ahead because I was running into trouble with some of my elements. Most of the problems were something obvious, such as me not adding my setup method to the constructor method or something like that, for the most part it was tedious but nothing far beyond my scope.

Problems I faced:
Organization was fairly difficult for me this time around just because of the sheer amount of elements in this project.
Layout was hard for me at first. I tried playing around with gridlayout etc. but ended up just setting the size of my Frame and setting my elements using the setbounds method.
