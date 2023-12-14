# Servlet

## Brief Description

*Servlet* is the layer communicating between *DAO* and *View*(or saying frontend).

Like *DAO* not one-to-one with *Entity*, *Servlet* is also not one-to-one with *DAO*.

## Class Explanation

- **[castInsertServlet](castInsertServlet.java)**
  - Web servlet (API for the front): '/castInsert'.
  - Function: Insert a new piece of information for *Cast*.
- **[castUpdateServlet](castUpdateServlet.java)**
    - Web servlet (API for the front): '/castUpdate'.
    - Function: Update a piece of information for *Cast*.
- **[genreServlet](genreServlet.java)**
    - Web servlet (API for the front): '/genre'.
    - Function: Return a list of *Movies* of certain *Genre*.
- **[headerServlet](headerServlet.java)**
    - Web servlet (API for the front): '/header'.
    - Function: Return a list of all the *Genres*.
- **[homeServlet](homeServlet.java)**
    - Web servlet (API for the front): '/home'.
    - Function: Return a List of Top hottest/latest *Movies*.
- **[movieDetailServlet](movieDetailServlet.java)**
    - Web servlet (API for the front): '/movieDetail'.
    - Function: Return a piece of detailed information of a certain *Movie*.
- **[movieInsertServlet](movieInsertServlet.java)**
    - Web servlet (API for the front): '/movieInsert'.
    - Function: Insert a new piece of information for *Movie*.
- **[movieUpdateServlet](movieUpdateServlet.java)**
    - Web servlet (API for the front): '/movieUpdate'.
    - Function: Update a piece of information for *Movie*.
- **[personDetailServlet](personDetailServlet.java)**
    - Web servlet (API for the front): '/personDetail'.
    - Function: Return a piece of detailed information of a certain *Person*.
- **[personInsertServlet](personInsertServlet.java)**
    - Web servlet (API for the front): '/personInsert'.
    - Function: Insert a new piece of information for *Person*.
- **[personUpdateServlet](personUpdateServlet.java)**
    - Web servlet (API for the front): '/personUpdate'.
    - Function: Update a piece of information for *Person*.
