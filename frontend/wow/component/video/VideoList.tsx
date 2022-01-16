import Link from 'next/link';
import React from 'react';
import {Grid} from "semantic-ui-react";
import styles from "../../styles/ItemList.module.css"

const VideoList = ({list}:any) => {
    return (
        <div>
            <Grid columns={3}>
                <Grid.Row>
                    {list.map((item: any) => (
                        <Grid.Column key={item.id}>
                            <Link href={`/view/${item.id}`}>
                                <a>
                                    <div className={styles.wrap}>
                                        <img src={item.image_link}
                                             alt={item.name}
                                             className={styles.img_item}
                                        />
                                        <strong className={styles.tit_item}>{item.name}</strong>
                                        <span className={styles.txt_info}>
                                            {item.category} {item.product_type}
                                        </span>
                                        <strong className={styles.num_price}>{item.price}</strong>
                                    </div>
                                </a>
                            </Link>
                        </Grid.Column>
                    ))}
                </Grid.Row>
            </Grid>
        </div>
    );
};

export default VideoList;
