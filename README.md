基于ElasticSearch的搜房网项目

ES索引结构创建语句
```
PUT /xunwu
{
  "mappings": {
    "house": {
      "dynamic": false,
      "properties": {
        "houseId": {
          "type": "long"
        },
        "title": {
          "type": "text",
          "index": "analyzed"
        },
        "price": {
          "type": "integer" 
        },
        "area": {
          "type": "integer"
        },
        "createTime": {
          "type": "date",
          "format": "strict_date_optional_time || epoch_millis"
        },
        "lastUpdateTime": {
          "type": "date",
          "format": "strict_date_optional_time || epoch_millis"
        },
        "cityEnName": {
          "type": "keyword"
        },
        "regionEnName": {
          "type": "keyword"
        },
        "direction": {
          "type": "integer"
        },
        "distanceToSubway": {
          "type": "integer"
        },
        "subwayLineName": {
          "type": "keyword"
        },
        "subwayStationName": {
          "type": "keyword"
        },
        "tags": {
          "type": "text"
        },
        "street": {
          "type": "keyword"
        }, 
        "district": {
          "type": "keyword"
        },
        "description": {
          "type": "text",
          "index": "analyzed"
        },
        "layoutDesc": {
          "type": "text",
          "index": "analyzed"
        },
        "traffic": {
          "type": "text",
          "index": "analyzed"
        },
        "roundService": {
          "type": "text",
          "index": "analyzed"
        },
        "rentWay": {
          "type": "integer"
        }
      }
    }
  }
}
```



**对"number_of_replica": 0设置的说明：**

"number_of_replica": 0，由于ES默认会创建5个primary shard并且为每个分片都创建1个replica shard，并且某个副本replica shard和其对应的primary shard不能在同一个节点上，因此当只有一个ES节点时，replica shard不能被创建，因此ES的分片健康值就是5/10，故会报黄。当只有1个ES节点时，建议做此设置不让ES创建replica shard；大于1个节点时无需做此设置。

**对索引中主要字段的说明：**

- houseId: 对应mysql中house表房源的主键id，用于搜索到结果后便于找到mysql中的数据。
- title: 房源标题，text类型，需要分词，需要被分析。
- price：integer类型，用于范围搜索和排序。
- createTime：date类型，用于排序。
- cityEnName：城市名称，keyword类型，固定名称，无需分词。
- subwayLineName：地铁线路名，keyword类型，固定名称，无需分词。
- tags：标签，text类型，在mysql表结构中是数组类型。数组类型在ES中可以定义为text类型，当数组的json从ES中写出时，ES会自动将json转换为数据。