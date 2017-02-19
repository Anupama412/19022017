"use strict";
var Topic = React.createClass({
	 getInitialState: function() {
		    return {};
		  },
	componentDidMount: function() {
		    var component = this;
		    $.get("https://api.github.com/users/mojombo", function(data) {
		      component.setState(data);
		    });
		    },		 
 render: function() {
    return (
      <div>
        <h3>{this.state.location}</h3>
        <h4>{this.state.name}</h4>
        </div>
    );
  }
});
ReactDOM.render(<Topic/>,document.getElementById("App"));
