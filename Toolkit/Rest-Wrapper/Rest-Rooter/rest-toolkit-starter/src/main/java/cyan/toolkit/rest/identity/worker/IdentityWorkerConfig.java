package cyan.toolkit.rest.identity.worker;

/**
 * <p>IdentityWorkerConfig</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:36 2020/1/13
 */
class IdentityWorkerConfig {
    static final Long OFFSET = 1L;
    static final Long SEQUENCE = 0L;
    static final Long TIMESTAMP = -1L;
    private static final Long SEQUENCE_BIT = 12L;
    private static final Long WORKER_ID_BIT = 5L;
    private static final Long CENTER_ID_BIT = 5L;
    static final Long SEQUENCE_MASK = ~(TIMESTAMP << SEQUENCE_BIT);
    static final Long MIN_WORKER_ID = SEQUENCE;
    static final Long MIN_CENTER_ID = SEQUENCE;
    static final Long MAX_WORKER_ID = ~(TIMESTAMP << WORKER_ID_BIT);
    static final Long MAX_CENTER_ID = ~(TIMESTAMP << CENTER_ID_BIT);
    static final Long WORKER_ID_SHIFT = SEQUENCE_BIT;
    static final Long CENTER_ID_SHIFT = SEQUENCE_BIT + WORKER_ID_BIT;
    static final Long TIMESTAMP_SHIFT = SEQUENCE_BIT + WORKER_ID_BIT + CENTER_ID_BIT;

    static final Integer TIMESTAMP_BIT_SIZE = 42;
    static final Integer REGION_BIT_SIZE = 10;
    private static final Integer MIN_REGION_SIZE = 1;
    static final Integer MAX_REGION_SIZE = MIN_REGION_SIZE << REGION_BIT_SIZE;
    private static final Integer SEQUENCE_BIT_SIZE = 12;
    static final Integer ALL_BIT_SIZE = TIMESTAMP_BIT_SIZE + REGION_BIT_SIZE + SEQUENCE_BIT_SIZE;

    static final Long DEFAULT_TAG = 1L;

}
