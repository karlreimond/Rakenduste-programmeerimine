import React from "react";
import ReactDOM from "react-dom";

export default class ToDoList extends React.Component {
  state = {
    tasks: [
      {
        id: 0,
        description: "Try Render Prop",
        completed: true
      }
    ],
    newTask: ""
  };

  render() {
    const { tasks } = this.state;
    const renderTasks = tasks.map(task => {
      return (
        <li key={task.id} className={task.completed ? "Completed" : null}>
          {task.description}
          <input
            type="button"
            value="Done"
            onClick={this._handleClickDone(task.id)}
          />
        </li>
      );
    });
    return (
      <div>
        <form>
          <label>
            New Task
            <input
              type="text"
              value={this.state.newTask}
              onChange={this._handleChangeNewTask}
            />
          </label>
          <input type="button" value="Add" onClick={this._handleClickAdd} />
        </form>
        <ul>{renderTasks}</ul>
      </div>
    );
  }

  _handleChangeNewTask = event => {
    this.setState({
      newTask: event.target.value
    });
  };

  _handleClickAdd = () => {
    if (this.state.newTask !== "") {
      this.setState({
        tasks: [
          ...this.state.tasks,
          {
            id: this.state.tasks.length,
            description: this.state.newTask,
            completed: false
          }
        ]
      });
    }
  };

  _handleClickDone = taskId => () => {
    const updatedTasks = [...this.state.tasks];
    const competedTaskIndex = this.state.tasks.findIndex(
      task => task.id === taskId
    );
    updatedTasks[competedTaskIndex].completed = true;

    this.setState({
      tasks: updatedTasks
    });
  };
}

const rootElement = document.getElementById("root");
ReactDOM.render(<ToDoList />, rootElement);