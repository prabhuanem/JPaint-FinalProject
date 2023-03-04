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

**This project will be implemented in 4 sprints**

Current Implementation is w.r.t Sprint - 1. Below is the overview of the current project as on Sprint - 1

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

Note : Will get this fixed in the upcoming sprint's

**Sprint - 3**

**Features Implemented**

    1. Implemented drawing Decorator (Which decorates the shape with a dashed line when the shape is selected)
    2. Implemented Copy, Paste and Delete Functionalities
    3. Implemented Undo/Redo of Paste and Delete functionalities

**Bugs (Sprint - 3)**

    1. When shapes created are overlapped and when selecting both the shapes are getting selected. Will try to fix it in next sprint

**Design Patterns**

Below are the design patterns implemented in this project

    1. Factory Method Pattern
    2. Command Pattern
    3. Strategy Pattern
    4. Builder Pattern
    5. Decorator Pattern
