/**
 *
 */
package com.perforce.p4java.option.server;

import com.perforce.p4java.exception.OptionsException;
import com.perforce.p4java.option.Options;
import com.perforce.p4java.server.IServer;

import java.util.List;

/**
 * Options class for the IOptionsServer's searchJobs method.
 */
public class SearchJobsOptions extends Options {

	/**
	 * Options: -m[max]
	 */
	public static final String OPTIONS_SPECS = "i:m:gtz";


	/**
	 * If greater than zero, limit output to the first maxResults
	 * number of job IDs. Corresponds to '-m max' flag.
	 */
	protected int maxResults = 0;

	/**
	 * Default constructor.
	 */
	public SearchJobsOptions() {
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
	public SearchJobsOptions(String... options) {
		super(options);
	}

	/**
	 * Explicit value constructor.
	 *
	 * @param maxResults maxResults
	 */
	public SearchJobsOptions(int maxResults) {
		super();
		this.maxResults = maxResults;
	}

	/**
	 * @see com.perforce.p4java.option.Options#processOptions(com.perforce.p4java.server.IServer)
	 */
	public List<String> processOptions(IServer server) throws OptionsException {
		this.optionList = this.processFields(OPTIONS_SPECS,
				this.getMaxResults());

		return this.optionList;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public SearchJobsOptions setMaxResults(int maxResults) {
		this.maxResults = maxResults;
		return this;
	}

}
