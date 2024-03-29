/**
 *
 */
package com.perforce.p4java.option.server;

import com.perforce.p4java.exception.OptionsException;
import com.perforce.p4java.option.Options;
import com.perforce.p4java.server.IServer;

import java.util.List;

/**
 * Combined Options subclass for the server create / update / delete stream methods.
 */
public class StreamOptions extends Options {

	/**
	 * Options: -f
	 */
	public static final String OPTIONS_SPECS = "b:f";

	/**
	 * If true, force the stream create / update / delete operation.
	 * Corresponds to the -f flag.
	 * */
	public boolean forceUpdate = false;

	/**
	 * Default constructor.
	 */
	public StreamOptions() {
		super();
	}

	/**
	 * Strings-based constructor; see 'p4 help [command]' for possible options.
	 * <p>
	 *
	 * <b>WARNING: you should not pass more than one option or argument in each
	 * string parameter. Each option or argument should be passed-in as its own
	 * separate string parameter, without any spaces between the option and the
	 * option value (if any).</b>
	 * <p>
	 *
	 * <b>NOTE: setting options this way always bypasses the internal options
	 * values, and getter methods against the individual values corresponding to
	 * the strings passed in to this constructor will not normally reflect the
	 * string's setting. Do not use this constructor unless you know what you're
	 * doing and / or you do not also use the field getters and setters.</b>
	 *
	 * @param options options
	 * @see com.perforce.p4java.option.Options#Options(java.lang.String...)
	 */
	public StreamOptions(String... options) {
		super(options);
	}

	/**
	 * Explicit-value constructor.
	 *
	 * @param forceUpdate forceUpdate
	 */
	public StreamOptions(boolean forceUpdate) {
		super();
		this.forceUpdate = forceUpdate;
	}

	/**
	 * @see com.perforce.p4java.option.Options#processOptions(com.perforce.p4java.server.IServer)
	 */
	public List<String> processOptions(IServer server) throws OptionsException {
		this.optionList = this.processFields(OPTIONS_SPECS, this.isForceUpdate());
		return this.optionList;
	}

	public boolean isForceUpdate() {
		return forceUpdate;
	}

	public StreamOptions setForceUpdate(boolean forceUpdate) {
		this.forceUpdate = forceUpdate;
		return this;
	}
}
