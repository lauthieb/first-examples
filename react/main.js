var MyComponent = React.createClass({
    render: function(){
        return (
            <h1>Hello {this.props.name} !</h1>
        );
    }
});

ReactDOM.render(
    <MyComponent name="World" />,
    document.getElementById('container')
);

var Counter = React.createClass({
    incrementCount: function(){
        this.setState({
            count: this.state.count + 1
        });
    },
    getInitialState: function(){
        return {
            count: 0
        }
    },
    render: function(){
        return (
            <div class="my-component">
                <h1>Count: {this.state.count}</h1>
                <button type="button" onClick={this.incrementCount}>Increment</button>
            </div>
        );
    }
});

ReactDOM.render(<Counter/>, document.getElementById('counter'));

var FilteredList = React.createClass({
    filterList: function(event){
        var updatedList = this.state.initialItems;
        updatedList = updatedList.filter(function(item){
            return item.toLowerCase().search(
                    event.target.value.toLowerCase()) !== -1;
        });
        this.setState({items: updatedList});
    },
    getInitialState: function(){
        return {
            initialItems: [
                "Apples",
                "Broccoli",
                "Chicken",
                "Duck",
                "Eggs",
                "Fish",
                "Granola",
                "Hash Browns"
            ],
            items: []
        }
    },
    componentWillMount: function(){
        this.setState({items: this.state.initialItems})
    },
    render: function(){
        return (
            <div className="filter-list">
                <input type="text" placeholder="Search" onChange={this.filterList}/>
                <List items={this.state.items}/>
            </div>
        );
    }
});

var List = React.createClass({
    render: function(){
        return (
            <ul>
                {
                    this.props.items.map(function(item) {
                        return <li key={item}>{item}</li>
                    })
                }
            </ul>
        )
    }
});

ReactDOM.render(<FilteredList/>, document.getElementById('filtered-list'));