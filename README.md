# JPaint-Final
#### AUTHOR - Mani Ratna Sai Prabhu Teja, Anem

This is Project where we will be building an “MS Paint”-like application in Java called JPaint

Features to be Created
Pick a shape

    o Ellipse
    o Triangle
    o Rectangle
- Pick a primary color
- Pick a secondary color
- Select shading type (outline only, filled-in, outline and filled-in)
- Click and drag to draw a shape
- Click and drag to select shapes
- Click and drag to move selected shapes
- Copy selected shapes
- Paste copied shapes
- Delete selected shapes
- Undo last action
- Redo last action
- Group selected shapes
- Ungroup selected shapes
- Selected shapes have dashed outline

**This project is implemented in 4 sprints**

**GitHub Repo**

Here is the link to the GitHub Repo - https://github.com/prabhuanem/JPaint-FinalProject 

Here is the Link to the README file (Mark Down) which is part of GitHub report - https://github.com/prabhuanem/JPaint-FinalProject/blob/master/README.md

**Sprint - 1**

**Features Implemented**

    1. Rectangle drawing Drawing
    2. Undo/Redo functionality

**Key Points**

    1. Even though in the UI other shapes like "Elipse", "Triangle" are present as of now only "Rectangle" is implemented by default
    2. Primary Color is also set by default
    3. Also the Shading Type is set to default of "Filled In" where by default all the shapes in this case it will be filled in rectangles

**Sprint - 2**

**Features Implemented**

    1. Other 2 shapes (Triangle and Ellipse) are implemented
    2. All the shading types (FilledIn, Outline and Outline_Filled_In) are implemented
    3. Select Functionality has been implemented
    4. Move functionality has been implemented along with Undo/Redo of Move has been implemented

**Sprint - 3**

**Features Implemented**

    1. Implemented drawing Decorator (Which decorates the shape with a dashed line when the shape is selected)
    2. Implemented Copy, Paste and Delete Functionalities
    3. Implemented Undo/Redo of Paste and Delete functionalities

**Sprint - 4**

**Features Implemented**

    1. Implemented "Group" and "Ungroup" of the shapes functionality

**Design Patterns**

Below are the design patterns implemented in this project
Mentioned in detailed in the PDF here - https://github.com/prabhuanem/JPaint-FinalProject/blob/master/Design%20Pattern.pdf

    1. Factory Method Pattern
    2. Command Pattern
    3. Strategy Pattern
    4. Builder Pattern
    5. Decorator Pattern
    6. Composite Pattern

**<h1 style ="font-size:14 ; color:cyan">Extra Credits</h1>**

**New Additional Shapes**

    1. Star
    2. Diamond
    3. Rounded Rectangle
    4. Rectangle Callout
    5. Octagon
Note : All these new shapes have the same existing functionality which Ellipse, Rectangle and Triangle have

**<h2 style ="color:cyan">Features Implemented</h2>**

**<h3 style ="color:cyan">Grid Toggle</h3>**
    
    1. Created a new button (Event) which helps to display grids on the Paint Canvas
    2. Using the Toggle_Grid user can toggle Grid Layout

**Future Scope**

    1. Free shape drawing can be done easliy using the grid layer
    2. Shapes can be snapped to the grid for proper alignment

**<h3 style ="color:cyan">Eraser Tool</h3>**

    1. Added a Mouse Mode 'ERASER'
    2. After drawing the shapes user can select the 'ERASER' from Mouse Mode to enable eraser mode
    3. User need to click and drag the cursor. When the ERASER bounds intersect the shape which needs to be erased.
    4. When the Eraser bounds and Shape intersects then the shape is erased

**Current Functionality & Issue**

    1. After erasing the shapes, when user clicks on UNDO, shape is not getting repainted
    2. But when we click REDO then the shapes are gettig repainted again on the canvas
    3. Here after Undo and Redo function works accordingly

**Future Scope**

    1. Shapes can be partially erased and the new shape can be displayed
    2. This gives more freedom for the users to draw complex shapes

**<h3 style ="color:cyan">KeyBoard Shortcuts (For ShapeType)</h3>**

    1. Implemented keyboard short cuts to change the shapetype which allows user to draw different with just a press of a key

**ShortCuts**

-   ELLIPSE - 'Key : E'
- RECTANGLE - 'Key : R'
- TRIANGLE - 'Key : T'
- STAR - 'Key : S'
- DIAMOND - 'Key : D'
- ROUNDED RECTANGLE - 'Key : C'
- RECTANGLE CALLOUT - 'Key : L'
- OCTAGON - 'Key : O'

**Current Functionality**

    1. In Draw mode user has to click on the Key as per the Shapetype required
    2. Currently this is working when the application is run and in the default mode.

**Future Scope**

    1.Shortcut keys can be implemented across the application for various functions which enhances the user experience

**<h2 style ="color:cyan">Bugs</h2>**

    1. Moving the Grouped Shapes is working weirdly. Shapes are getting stacked

Note : However when multiple individual shapes are selected together and moved it is working as intended. Observing this issue when those shapes are grouped

    2. Similarly to "Moving" the grouped shapes, When Pasting the Copied groupShape. Only the outer boundary of the GroupShape is visible in "Red", but the shapes inside the group are not getting displayed

Note : When we select the "Shape/Shapes" and copy them we have to click on the screen on where the copied shapes need to be pasted
        After clicking on the screen user have to press paste for shapes to be pasted there

**<h2>Efforts/Approaches tried to fix the issues</h2>**

**For Moving GroupShape Issue**

1. Tried calculating the relative positions between the shapes inside the group
2. Tried to Ungroup momentarily while moving and Group back again after moving is done (Since when multiple individual shapes are selected and moved everything is working as intended)

**For Pasting GroupShape Issue**

1. Similar to the MoveShape Issue. While pasting the shape momentarily ungroup the shapes paste the individual shapes in the group first and group them again after successful pasting

**<h1>Challenging Aspects of the Project</h1>**

1. Implementing 5 different Design Patterns
2. Choosing most suitable Patterns from the pool of design patterns for better control and efficiency
3. Major challenge which I faced is while implementing "Group" and "Ungroup" these were tricky
4. Moving all the sub shapes which are part of group while maintaining the relative positions between them is tricky

