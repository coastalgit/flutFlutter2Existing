import 'package:flutter/material.dart';

import 'main.dart';

class Page3 extends StatefulWidget {

  //static const String routeName = '/routepage3';

  @override
  _Page3State createState() => _Page3State();
}

class _Page3State extends State<Page3> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Page 3'),
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
            'Testing \'back\' and \'home\'functionality',
            style: TextStyle(fontSize: 16.0),
          ),
          Container(height: 15),
          RawMaterialButton(
            padding: EdgeInsets.all(16.0),
            fillColor: Colors.blue.shade700,
            child: Text('Go HOME', style: TextStyle(color: Colors.white),),
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(5.0),
            ),
            onPressed: () {
              _navigateHome();
            },
          ),
        ],
      ),
    );
  }

  _navigateHome(){
    Navigator.popUntil(context, ModalRoute.withName(Navigator.defaultRouteName));
  }
}
