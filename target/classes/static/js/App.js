"use strict";
var Topic = React.createClass({
	 getInitialState: function() {
		    return {topicsList:[]};
		  },
	componentDidMount: function() {
		    var component = this;
		    $.get("http://localhost:8080/topics",function(topicsList) {
		    	 component.setState({topicsList});
		       		    });
		    },		 
     render: function() {
    	 // console.log('exampleComponent mounted'+this.state.topicsList);
	    return (
	    	      <TopicsList topicsList={this.state.topicsList}/>
	    );
  }
});

var TopicsList= React.createClass({
	 
	  render:function(){
		  
		 // console.log('New property'+this.props.topicsList);
		 // console.log('New satte'+ this.state.topicsList);
		  var topicsList = this.props.topicsList.map(function(myTopic) {
		     	return	<EachTopic myTopic={myTopic}/>
			    });
	          
		  return(
				  <div class="container">
				  <table class="table">
					<tbody>
						<tr>
							<th>Description</th>
							<th>Name</th>
							<th>Id</th>
						</tr>
						{topicsList}
					</tbody>
				</table>
				</div>
				  
		  );		  
	  }
	
});
	 
	 
var EachTopic=React.createClass({
	render: function(){
		
        console.log('myTopic'+this.props.myTopic.description);

		return(
				<tr>
				<td>{this.props.myTopic.description}</td>
				<td>{this.props.myTopic.name}</td>
				<td>{this.props.myTopic.id}</td>
			</tr>
			);
	   }
	
});
ReactDOM.render(<Topic/>,document.getElementById("App"));
