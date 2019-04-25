import 'dart:ui';
import 'package:flutter/material.dart';

//void main() => runApp(_widgetForRoute(window.defaultRouteName, title));
void main() => runApp(_widgetForRoute(window.defaultRouteName));

//Widget _widgetForRoute(String theRoute, String theTitle){
Widget _widgetForRoute(String theRoute) {
  return MaterialApp(
    home: _buildEmbeddedPage(theRoute),
  );
}

Widget _buildEmbeddedPage(String myRoute){
  switch (myRoute) {
    case 'route1':
      return MyFlutterPage(title: 'Ola from Flutter');
    default:
      return DefaultPage();
  }
}

class DefaultPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        //child: Text('Default page'),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Text('Default page'),
            ],
          ),
        ),

    );
  }
}

class MyFlutterPage extends StatefulWidget {
  MyFlutterPage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyFlutterPageState createState() => _MyFlutterPageState();
}

class _MyFlutterPageState extends State<MyFlutterPage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
//      appBar: AppBar(
//        title: Text(widget.title),
//      ),
      body: Container(
        color: Colors.blue.shade800,
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Text(
                widget.title,
                style: TextStyle(color: Colors.white),
              ),
              Container(height: 10),
              Text(
                'You have clicked $_counter times:',
                style: TextStyle(color: Colors.white),
              ),
//              Text(
//                '$_counter',
//                style: Theme.of(context).textTheme.display1,
//              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ),
    );
  }
}
