package cc.co.evenprime.bukkit.nocheat.config;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;


public class ParentOption extends Option {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3162246550749560727L;

	private final LinkedList<Option> children = new LinkedList<Option>();
	private final boolean editable;

	public ParentOption(String identifier, boolean editable) {
		super(identifier);
		this.editable = editable;
	}

	public final Collection<Option> getChildOptions() {
		return Collections.unmodifiableCollection(children);
	}

	public final void add(Option option) {
		children.addLast(option);
		option.setParent(this);
	}

	public final void remove(Option option) {
		if(editable)
			children.remove(option);
	}

	public boolean isEditable() {
		return editable;
	}

	@Override
	public String toYAMLString(String prefix) {

		String s = "";
		if(getIdentifier().length() > 0) {
			s += prefix + getIdentifier() + ":\r\n";

			for(Option o : getChildOptions()) {
				s += o.toYAMLString(prefix + "    ");
			}
		}
		else
		{
			for(Option o : getChildOptions()) {
				s += o.toYAMLString(prefix);
			}
		}

		return s;
	}

	@Override
	public String toDescriptionString(String prefix) {

		String s = "";
		if(getIdentifier().length() > 0) {
			s += prefix + getIdentifier() + ":\r\n";

			for(Option o : getChildOptions()) {
				s += o.toDescriptionString(prefix + "    ");
			}
		}
		else
		{
			for(Option o : getChildOptions()) {
				s += o.toDescriptionString(prefix);
			}
		}

		return s;

	}
}
