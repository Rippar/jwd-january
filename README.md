# jwd-january

Text object consists of the list of TextElement objects. TextElement is an abstract class, which contains a static int field "count" used to fix a serial number of current TextElement object. Also we have 3 subclasses of TextElement: CodeBlock, Headline and Paragraph, which contain their own counter in order to keep track of the number of created objects, as well as assign its own value to the id field (fields "count" and "id" are not used in the functionality of the current application, but can be used if it is necessary to restore the initial order of the elements). Also we have a String field which is a string representation of the current element.

The order of the text elements in the Text object allows us to restore the text to its original condition.

TextParser class parse the given text to the TextElement objects and returns the Text object, which is used in a TextLogic class which allows to conduct the different operations with text elements thereby modifying the Text object.

Selected operations for implementation in logic: №5, №7 &  №12

Thanks for reviewing my code.