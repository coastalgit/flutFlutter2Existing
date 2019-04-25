import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

//void main() => runApp(_widgetForRoute(window.defaultRouteName, title));
void main() => runApp(_widgetForRoute(window.defaultRouteName));

//Widget _widgetForRoute(String theRoute, String theTitle){
Widget _widgetForRoute(String theRoute) {
  return MaterialApp(
    home: _buildEmbeddedPage(theRoute),
  );
}

Widget _buildEmbeddedPage(String myRoute){
  print('_buildEmbeddedPage route:[$myRoute]');
  switch (myRoute) {
    case 'route1':
      return MyFlutterPage1(title: 'Ola from Flutter 1');
    case 'route2':
      return MyFlutterPage2(title: 'Ola from Flutter 2');
    default:
      return DefaultPage();
  }
}

/*
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
*/

class DefaultPage extends StatefulWidget {
  @override
  _DefaultPageState createState() => _DefaultPageState();
}

class _DefaultPageState extends State<DefaultPage> {

  static const platform = const MethodChannel('com.example.2flutter/comtest');

  @override
  Widget build(BuildContext context) {
    return _buildMessageView();
  }

  Widget _buildMessageView(){
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
                'Default Route',
                style: TextStyle(color: Colors.white),
              ),
              Container(height: 10),
              RawMaterialButton(
                padding: EdgeInsets.all(16.0),
                fillColor: Colors.red,
                child: Text('Get native message', style: TextStyle(color: Colors.white),),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(5.0),
                ),
                onPressed: () {
                  _getNativeMessage();
                },
              ),
              Container(height: 15,),
              Text(
                'Msg: [$_nativeMessage]',
                style: TextStyle(color: Colors.white),
              ),
            ],
          ),
        ),
      ),
    );
  }

  String _nativeMessage = 'Not available';

  Future<void> _getNativeMessage() async {
    String nativeMessage;
    try {
      final String result = await platform.invokeMethod('getNativeMessage');
      nativeMessage = result;
    } on PlatformException catch (e) {
      nativeMessage = "Failed to get native message: '${e.message}'.";
    }

    setState(() {
      _nativeMessage = nativeMessage;
    });
  }

}

class MyFlutterPage1 extends StatefulWidget {
  MyFlutterPage1({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyFlutterPage1State createState() => _MyFlutterPage1State();
}

class _MyFlutterPage1State extends State<MyFlutterPage1> {


  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }


  @override
  Widget build(BuildContext context) {
    return _buildCounterView();
    //return _buildMessageView();
  }

  Widget _buildCounterView(){
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

class MyFlutterPage2 extends StatefulWidget {
  MyFlutterPage2({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyFlutterPage2State createState() => _MyFlutterPage2State();
}

class _MyFlutterPage2State extends State<MyFlutterPage2> {

  static const String _channel = 'com.example.2flutter/comtestevent';
  static const BasicMessageChannel<String> platform = BasicMessageChannel<String>(_channel, StringCodec());

  String _nativeMessage = 'Empty Message';

  @override
  void initState() {
    super.initState();
    platform.setMessageHandler(_handlePlatformMessage);
    // note see https://medium.com/grandcentrix/use-flutter-in-existing-android-apps-ac07e2072781 for example of List passing
  }

  @override
  Widget build(BuildContext context) {
    return _buildMessageView();
  }

  Widget _buildMessageView(){
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
              RawMaterialButton(
                padding: EdgeInsets.all(16.0),
                fillColor: Colors.red,
                child: Text('Send message to native', style: TextStyle(color: Colors.white),),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(5.0),
                ),
                onPressed: () {
                  _sendMessageToNative('Ola from Flutter');
                },
              ),
              Container(height: 15,),
              Text(
                'Msg: [$_nativeMessage]',
                style: TextStyle(color: Colors.white),
              ),
            ],
          ),
        ),
      ),
    );
  }



  void _sendMessageToNative(String msg){
    platform.send(msg);
  }

//  Future<void> _getNativeMessage() async {
//    String nativeMessage;
//    try {
//      final String result = await platform.invokeMethod('getNativeMessage');
//      nativeMessage = result;
//    } on PlatformException catch (e) {
//      nativeMessage = "Failed to get native message: '${e.message}'.";
//    }
//
//    setState(() {
//      _nativeMessage = nativeMessage;
//    });
//  }


  Future<String> _handlePlatformMessage(String message) async{
    print('_handlePlatformMessage msg=['+message!=null?message:'Nada'+']');
    if (message != null) {
      setState(() {
        _nativeMessage = message;
      });
    }
  }
}


