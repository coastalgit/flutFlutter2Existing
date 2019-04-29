import 'package:flutter/material.dart';

class Page2 extends StatefulWidget {

  static const String routeName = '/routepage2';

  @override
  _Page2State createState() => _Page2State();
}

class _Page2State extends State<Page2> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Page 2'),
      ),
      body: _buildBody(),
    );
  }

  Widget _buildBody() {
    return Center(
      child: Column(
        //crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Text(
            'Testing \'back\' functionality',
            style: TextStyle(fontSize: 16.0),
          ),
        ],
      ),
    );
  }
}
