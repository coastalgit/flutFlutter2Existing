import 'package:flutter/material.dart';
import 'package:flutterembed/page3.dart';

class Page2 extends StatefulWidget {

  //static const String routeName = '/routepage2';

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
          Container(height: 15),
          RawMaterialButton(
            padding: EdgeInsets.all(16.0),
            fillColor: Colors.green,
            child: Text('Show third Flutter page', style: TextStyle(color: Colors.white),),
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(5.0),
            ),
            onPressed: () {
              _showPage3(context);
            },
          ),
        ],
      ),
    );
  }
}

void _showPage3(BuildContext context){
  Navigator.push(context,  MaterialPageRoute(
      builder: (BuildContext context) => Page3()));
}
