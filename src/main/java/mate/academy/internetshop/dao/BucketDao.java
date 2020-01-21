package mate.academy.internetshop.dao;

import mate.academy.internetshop.model.Bucket;

public interface BucketDao extends GenericDao<Bucket, Long> {

    Bucket getByUserId(Long userId);
}
