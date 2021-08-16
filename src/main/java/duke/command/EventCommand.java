package duke.command;

import duke.Duke;
import duke.Response;
import duke.task.EventTask;

/**
 * A command to add an event task into main DukeList.
 */
public class EventCommand implements Command {

    @Override
    public void exec(String args) {
        if (args.isEmpty()) {
            new Response("☹ OOPS!!! The description of an event cannot be empty.").print();
        } else {
            Duke.getList().addWithResponse(new EventTask(args)).print();
        }
    }

    @Override
    public String getLabel() {
        return "event";
    }

}